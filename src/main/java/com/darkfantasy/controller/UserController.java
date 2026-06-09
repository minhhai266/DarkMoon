package com.darkfantasy.controller;

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

import com.darkfantasy.dto.user.ChangePasswordRequest;
import com.darkfantasy.dto.user.LoginRequest;
import com.darkfantasy.dto.user.RegisterRequest;
import com.darkfantasy.dto.user.UserResponse;
import com.darkfantasy.entity.User;
import com.darkfantasy.entity.enums.LogAction;
import com.darkfantasy.entity.enums.LogEntityType;
import com.darkfantasy.service.AuditLogService;
import com.darkfantasy.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/moonblight/")
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
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
    public String login(@Valid @ModelAttribute LoginRequest request, BindingResult result, Model model,
            HttpServletRequest req) {
        if (result.hasErrors()) {
            return "cms/auth/login";
        }
        try {
            // Authentication authentication = authenticationManager
            // .authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(),
            // request.getPassword()));
            // SecurityContextHolder.getContext().setAuthentication(authentication);
            // return "redirect:/";
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getLogin(),
                            request.getPassword()));

            SecurityContext context = SecurityContextHolder.createEmptyContext();

            context.setAuthentication(authentication);

            SecurityContextHolder.setContext(context);

            req.getSession(true).setAttribute(
                    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    context);

            boolean isAdmin = authentication
                    .getAuthorities()
                    .stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

            if (isAdmin) {
                return "redirect:/admin/moonblight/dashboard";
            }

            return "redirect:/dashboard/moonblight";
        } catch (AuthenticationException e) {
            model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng.");
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

        return "redirect:/";
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

    @GetMapping("/change-password")
    public String changePasswordPage(
            Model model) {

        model.addAttribute(
                "changePasswordRequest",
                new ChangePasswordRequest());

        return "cms/auth/change-password";
    }

    @PostMapping("/change-password")
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

            return "redirect:/dashboard/moonblight";

        } catch (Exception e) {

            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/user/change-password";
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
}
