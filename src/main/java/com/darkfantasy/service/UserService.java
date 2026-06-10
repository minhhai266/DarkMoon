package com.darkfantasy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.darkfantasy.dto.user.ChangePasswordRequest;
import com.darkfantasy.dto.user.ForgotPasswordRequest;
import com.darkfantasy.dto.user.LoginRequest;
import com.darkfantasy.dto.user.RegisterRequest;
import com.darkfantasy.dto.user.ResetPasswordRequest;
import com.darkfantasy.dto.user.UserResponse;
import com.darkfantasy.dto.user.VerifyOtpRequest;

public interface UserService {
    UserResponse findByUsername(String user);

    UserResponse login(LoginRequest request);

    void register(RegisterRequest request);

    // void changeForgottenPassword(ResetPasswordRequest request);
    void changeCurrentUserPassword(ChangePasswordRequest request);

    // void changeEmail(ChangeEmailRequest request);
    UserResponse findAccountById(Long id);

    Page<UserResponse> getAccounts(Pageable pageable);

    void lockUser(Long id);

    void unlockUser(Long id);

    long count();

    long countActiveUsers();

    long countInactiveUsers();

    void sendOtp(ForgotPasswordRequest request);

    void verifyOtp(VerifyOtpRequest request);

    void resetPassword(ResetPasswordRequest request);
}
