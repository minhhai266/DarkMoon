package com.darkfantasy.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.darkfantasy.dto.user.LoginRequest;
import com.darkfantasy.dto.user.RegisterRequest;

import com.darkfantasy.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/moonblight/")
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @GetMapping({ "login", "login/" })
    public String toLoginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "auth/login";
    }

    @GetMapping({ "register", "register/" })
    public String toRegisterPage(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "auth/register";
    }

    @GetMapping({ "reset", "reset/" })
    public String toResetPage() {
        return "auth/reset";
    }

    @GetMapping({ "change", "change/" })
    public String toChangePasswordPage() {
        return "auth/password-change";
    }

    @PostMapping("login")
    public String login(@Valid @ModelAttribute LoginRequest request, BindingResult result, Model model,
            HttpServletRequest req) {
        if (result.hasErrors()) {
            return "auth/login";
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

            return "redirect:/";
        } catch (AuthenticationException e) {
            model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng.");
            return "auth/login";
        }
    }

    @PostMapping("register")
    public String registerAccount(@Valid @ModelAttribute RegisterRequest request, BindingResult result,
            Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "auth/register";
        }
        try {
            userService.register(request);
            redirectAttributes.addFlashAttribute("successMessage", "Đăng ký thành công!");
            return "redirect:/user/moonblight/login";
        } catch (IllegalArgumentException e) {
            request.setPassword("");
            request.setRePassword("");
            model.addAttribute("errorMessage", e.getMessage());
            return "auth/register";
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
