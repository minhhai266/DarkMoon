package com.darkfantasy.service.impl;

import java.time.Instant;
import java.util.Optional;
import java.util.Random;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darkfantasy.dto.user.ChangePasswordRequest;
import com.darkfantasy.dto.user.ForgotPasswordRequest;
import com.darkfantasy.dto.user.LoginRequest;
import com.darkfantasy.dto.user.RegisterRequest;
import com.darkfantasy.dto.user.ResetPasswordRequest;
import com.darkfantasy.dto.user.UserResponse;
import com.darkfantasy.dto.user.VerifyOtpRequest;
import com.darkfantasy.entity.PasswordResetToken;
import com.darkfantasy.entity.User;
import com.darkfantasy.entity.enums.LogAction;
import com.darkfantasy.entity.enums.LogEntityType;
import com.darkfantasy.entity.enums.Role;
import com.darkfantasy.repository.PasswordResetTokenRepository;
import com.darkfantasy.repository.UserRepository;
import com.darkfantasy.service.AuditLogService;
import com.darkfantasy.service.UserService;
import com.darkfantasy.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuditLogService auditLogService;
    private final PasswordResetTokenRepository tokenRepository;
    private final JavaMailSender mailSender;

    @Transactional
    @Override
    public void register(RegisterRequest request) {
        if (existsByKeyword(request.getUsername())) {
            throw new IllegalArgumentException("Tên đăng nhập đã tồn tại!");
        }
        if (existsByKeyword(request.getEmail())) {
            throw new IllegalArgumentException("Email này đã được đăng ký!");
        }
        String hashPassword = passwordEncoder.encode(request.getPassword());
        User savedUser = userRepository.save(
                request.toEntity(hashPassword));
        auditLogService.log(
                LogEntityType.USER,
                null,
                LogAction.CREATE,
                "Đăng kí: " + savedUser.getUsername());
    }

    @Override
    public UserResponse login(LoginRequest request) {
        User user = findUser(request.getLogin())
                .orElseThrow(() -> new IllegalArgumentException("Sai tài khoản hoặc mật khẩu"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Sai tài khoản hoặc mật khẩu");
        }
        if (!user.isActive())
            throw new IllegalArgumentException("Sai tài khoản hoặc mật khẩu");
        auditLogService.log(
                LogEntityType.USER,
                user.getId(),
                LogAction.LOGIN,
                "Đăng Nhập: " + user.getUsername());
        return UserResponse.fromEntity(user);
    }

    @Override
    @Transactional
    public void changeCurrentUserPassword(
            ChangePasswordRequest request) {

        User currentUser = getCurrentUser();

        if (!passwordEncoder.matches(
                request.getOldPassword(),
                currentUser.getPassword())) {

            throw new IllegalArgumentException(
                    "Mật khẩu hiện tại không đúng");
        }

        if (!request.getNewPassword()
                .equals(request.getConfirmPassword())) {

            throw new IllegalArgumentException(
                    "Mật khẩu xác nhận không khớp");
        }

        currentUser.setPassword(
                passwordEncoder.encode(
                        request.getNewPassword()));

        currentUser.setMustChangePassword(false);
        auditLogService.log(
                LogEntityType.USER,
                currentUser.getId(),
                LogAction.UPDATE,
                "Đổi mật khẩu: " + currentUser.getUsername());
    }

    private Optional<User> findUser(String keyword) {
        return userRepository.findUserByUsernameOrEmail(keyword, keyword);
    }

    private boolean existsByKeyword(String keyword) {
        return userRepository.existsByUsernameOrEmail(keyword, keyword);
    }

    private User findUser(Long id) {
        return id == null ? null : userRepository.getReferenceById(id);
    }

    @Override
    public UserResponse findAccountById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Id không thể là null");
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy người dùng"));

        return UserResponse.fromEntity(user);
    }

    private User getCurrentUser() {

        String currentUsername = SecurityUtil.getCurrentUserName();

        if (currentUsername == null) {
            throw new IllegalStateException("Không tìm thấy người dùng hiện tại");
        }

        return userRepository
                .findUserByUsername(currentUsername)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy người dùng"));
    }

    @Override
    public Page<UserResponse> getAccounts(Pageable pageable) {
        return userRepository
                .findAllByOrderByIdAsc(pageable)
                .map(UserResponse::fromEntity);
    }

    @Transactional
    @Override
    public void lockUser(Long id) {
        User user = findUser(id);
        if (user.getRole() == Role.ADMIN)
            throw new IllegalArgumentException("Không có thẩm quyền");
        user.setActive(false);
        auditLogService.log(
                LogEntityType.USER,
                user.getId(),
                LogAction.LOCK,
                "Khóa tài khoản: " + user.getUsername());
    }

    @Transactional
    @Override
    public void unlockUser(Long id) {
        User user = findUser(id);
        if (user.getRole() == Role.ADMIN)
            throw new IllegalArgumentException("Không có thẩm quyền");
        user.setActive(true);
        auditLogService.log(
                LogEntityType.USER,
                user.getId(),
                LogAction.UNLOCK,
                "Mở khóa tài khoản: " + user.getUsername());
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public long countActiveUsers() {
        return userRepository.countByIsActiveTrue();
    }

    @Override
    public long countInactiveUsers() {
        return userRepository.countByIsActiveFalse();
    }

    @Override
    public UserResponse findByUsername(String username) {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy tài khoản"));
        return UserResponse.fromEntity(user);
    }

    @Transactional
    @Override
    public void sendOtp(ForgotPasswordRequest request) {

        User user = userRepository
                .findUserByEmail(
                        request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Email không tồn tại"));

        String otp = String.format(
                "%06d",
                new Random().nextInt(1000000));

        PasswordResetToken token = PasswordResetToken.builder()
                .email(user.getEmail())
                .otp(otp)
                .expiredAt(
                        Instant.now()
                                .plusSeconds(300))
                .used(false)
                .build();

        tokenRepository.save(token);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(user.getEmail());

        message.setSubject(
                "Mã OTP đặt lại mật khẩu");

        message.setText(
                "Mã OTP của bạn là: "
                        + otp
                        + "\n\nMã có hiệu lực trong 5 phút.");
        mailSender.send(message);

    }

    @Transactional(readOnly = true)
    @Override
    public void verifyOtp(
            VerifyOtpRequest request) {

        PasswordResetToken token = tokenRepository
                .findTopByEmailAndOtpAndUsedFalseOrderByIdDesc(
                        request.getEmail(),
                        request.getOtp())
                .orElseThrow(() -> new IllegalArgumentException(
                        "OTP không hợp lệ"));

        if (token.getExpiredAt()
                .isBefore(Instant.now())) {

            throw new IllegalArgumentException(
                    "OTP đã hết hạn");
        }
    }

    @Transactional
    @Override
    public void resetPassword(ResetPasswordRequest request) {

        PasswordResetToken token = tokenRepository
                .findTopByEmailAndOtpAndUsedFalseOrderByIdDesc(
                        request.getEmail(),
                        request.getOtp())
                .orElseThrow(() -> new IllegalArgumentException(
                        "OTP không hợp lệ"));

        if (token.getExpiredAt()
                .isBefore(Instant.now())) {

            throw new IllegalArgumentException(
                    "OTP đã hết hạn");
        }

        User user = userRepository
                .findUserByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Không tìm thấy người dùng"));

        user.setPassword(
                passwordEncoder.encode(
                        request.getNewPassword()));
        token.setUsed(true);
    }
}
