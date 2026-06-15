package com.darkfantasy.controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.darkfantasy.constant.Routes;
import com.darkfantasy.dto.user.ChangePasswordRequest;
import com.darkfantasy.dto.user.ForgotPasswordRequest;
import com.darkfantasy.dto.user.LoginRequest;
import com.darkfantasy.dto.user.RegisterRequest;
import com.darkfantasy.dto.user.ResetPasswordRequest;
import com.darkfantasy.dto.user.UserResponse;
import com.darkfantasy.dto.user.VerifyOtpRequest;
import com.darkfantasy.entity.enums.LogAction;
import com.darkfantasy.entity.enums.LogEntityType;
import com.darkfantasy.entity.enums.Role;
import com.darkfantasy.service.AuditLogService;
import com.darkfantasy.service.UserService;
import com.darkfantasy.util.SecurityUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(Routes.USER + "/")
public class UserController {
    private final UserService userService;
    private final AuditLogService auditLogService;

    @GetMapping({ "login", "login/" })
    public String toLoginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "cms/auth/login";
    }

    @GetMapping({ "register", "register/" })
    public String toRegisterPage(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "cms/auth/register";
    }

    @GetMapping({ "reset", "reset/" })
    public String toResetPage() {
        return "cms/auth/reset";
    }

    @GetMapping({ "change", "change/" })
    public String toChangePasswordPage() {
        return "cms/auth/password-change";
    }

    @PostMapping("login")
    public String login(
            @Valid @ModelAttribute LoginRequest request,
            BindingResult result,
            Model model,
            HttpServletRequest req) {

        if (result.hasErrors()) {
            return "cms/auth/login";
        }

        try {

            UserResponse user = userService.login(request);

            req.getSession(true).setAttribute(
                    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext());
            return switch (user.getRole()) {
                case "ADMIN" -> "redirect:/admin/moonblight/dashboard";
                case "STAFF" -> "redirect:/dashboard/moonblight";
                default -> "redirect:/";
            };

        } catch (AuthenticationException e) {

            model.addAttribute(
                    "errorMessage",
                    "Tên đăng nhập hoặc mật khẩu không đúng.");

            return "cms/auth/login";
        }
    }

    @PostMapping("logout")
    public String logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) {
        if (authentication != null) {
            String username = authentication.getName();
            UserResponse user = userService.findByUsername(username);
            auditLogService.log(
                    LogEntityType.USER,
                    user.getId(),
                    LogAction.LOGOUT,
                    "Đăng xuất");
        }

        new SecurityContextLogoutHandler()
                .logout(request, response, authentication);

        return "redirect:/user/moonblight/login";
    }

    @PostMapping("register")
    public String registerAccount(@Valid @ModelAttribute RegisterRequest request, BindingResult result,
            Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "cms/auth/register";
        }
        try {
            userService.register(request);
            redirectAttributes.addFlashAttribute("successMessage", "Đăng ký thành công!");
            return "redirect:/user/moonblight/login";
        } catch (IllegalArgumentException e) {
            request.setPassword("");
            request.setRePassword("");
            model.addAttribute("errorMessage", e.getMessage());
            return "cms/auth/register";
        }
    }

    @GetMapping("change-password")
    public String changePasswordPage(
            Model model) {

        model.addAttribute(
                "changePasswordRequest",
                new ChangePasswordRequest());
        return "cms/auth/change-password";
    }

    @PostMapping("change-password")
    public String changePassword(
            @Valid @ModelAttribute("changePasswordRequest") ChangePasswordRequest request,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "cms/auth/change-password";
        }

        try {

            userService.changeCurrentUserPassword(
                    request);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Đổi mật khẩu thành công");

            Role role = SecurityUtil.getCurrentUserRole();

            if (role == Role.ADMIN) {
                return "redirect:/admin/moonblight/dashboard";
            }

            return "redirect:/dashboard/moonblight";

        } catch (Exception e) {

            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/auth/change-password";
        }
    }
    // @PostMapping("reset/enter")
    // public String resetPassword(@Valid @ModelAttribute ResetPasswordRequest
    // request, BindingResult result,
    // Model model, RedirectAttributes redirectAttributes) {
    // if (result.hasErrors()) {
    // return "reset";
    // }
    // try {
    // userService.changeForgottenPassword(request);
    // redirectAttributes.addAttribute("successMessage", "Thay đổi mật khẩu thành
    // công!");
    // return "redirect:/user/login";
    // } catch (IllegalArgumentException e) {
    // model.addAttribute("errorMessage", e.getMessage());
    // return "reset";
    // }

    // }
    @GetMapping("forgot-password")
    public String forgotPasswordPage(
            Model model) {

        model.addAttribute(
                "forgotPasswordRequest",
                new ForgotPasswordRequest());

        return "cms/auth/forgot-password";
    }

    @PostMapping("forgot-password")
    public String forgotPassword(
            @Valid @ModelAttribute ForgotPasswordRequest request,
            BindingResult result, HttpSession session,
            Model model) {

        if (result.hasErrors()) {
            return "cms/auth/forgot-password";
        }

        try {

            userService.sendOtp(request);
            session.setAttribute(
                    "OTP_EMAIL",
                    request.getEmail());
            return "redirect:/user/moonblight/verify-otp";

        } catch (Exception e) {

            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/auth/forgot-password";
        }
    }

    @GetMapping("verify-otp")
    public String verifyOtpPage(HttpSession session,
            Model model) {
        VerifyOtpRequest request = new VerifyOtpRequest();
        request.setEmail(
                (String) session.getAttribute(
                        "OTP_EMAIL"));

        model.addAttribute(
                "verifyOtpRequest",
                request);
        return "cms/auth/verify-otp";
    }

    @PostMapping("verify-otp")
    public String verifyOtp(
            @Valid @ModelAttribute VerifyOtpRequest request,
            BindingResult result,
            HttpSession session,
            Model model) {

        if (result.hasErrors()) {
            return "cms/auth/verify-otp";
        }

        try {

            userService.verifyOtp(request);
            session.setAttribute(
                    "RESET_OTP",
                    request.getOtp());
            session.setAttribute(
                    "RESET_EMAIL",
                    request.getEmail());
            return "redirect:/user/moonblight/reset-password";

        } catch (Exception e) {
            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/auth/verify-otp";
        }
    }

    @GetMapping("/reset-password")
    public String resetPasswordPage(
            HttpSession session,
            Model model) {
        ResetPasswordRequest request = new ResetPasswordRequest();

        request.setEmail(
                (String) session.getAttribute(
                        "RESET_EMAIL"));

        request.setOtp(
                (String) session.getAttribute(
                        "RESET_OTP"));

        model.addAttribute(
                "resetPasswordRequest",
                request);

        return "cms/auth/reset-password";
    }

    @PostMapping("/reset-password")
    public String resetPassword(
            @Valid @ModelAttribute ResetPasswordRequest request,
            BindingResult result,
            HttpSession session,
            Model model,
            RedirectAttributes redirectAttributes) {
        System.out.println("RESET PASSWORD START");
        if (result.hasErrors()) {
            System.out.println("VALIDATION FALL " + result.getErrorCount());
            result.getAllErrors()
                    .forEach(System.out::println);
            return "cms/auth/reset-password";
        }

        try {

            String email = (String) session.getAttribute(
                    "RESET_EMAIL");

            String otp = (String) session.getAttribute(
                    "RESET_OTP");
            if (email == null || otp == null) {
                return "redirect:/user/moonblight/forgot-password";
            }
            request.setEmail(email);
            request.setOtp(otp);
            userService.resetPassword(request);

            session.removeAttribute(
                    "RESET_EMAIL");

            session.removeAttribute(
                    "RESET_OTP");

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Đổi mật khẩu thành công");

            return "redirect:/user/moonblight/login";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/auth/reset-password";
        }
    }
}
