package com.darkfantasy.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

import com.darkfantasy.constant.Routes;
import com.darkfantasy.dto.user.UserResponse;
import com.darkfantasy.service.AuditLogService;
import com.darkfantasy.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(Routes.ADMIN + "/")
public class AdminController {
        private final AuditLogService auditLogService;
        private final UserService userService;

        @GetMapping("dashboard")
        public String toDashboard(Model model) {
                model.addAttribute(
                                "totalUsers",
                                userService.count());

                model.addAttribute(
                                "activeUsers",
                                userService.countActiveUsers());

                model.addAttribute(
                                "inActiveUsers",
                                userService.countInactiveUsers());
                return "cms/admin/admin-dashboard";
        }

        @GetMapping("list")
        public String toAccountList(
                        @PageableDefault(size = 10) Pageable pageable,
                        Model model) {

                model.addAttribute(
                                "accounts",
                                userService.getAccounts(pageable));

                return "cms/admin/account-list";
        }

        @GetMapping("account/{id}")
        public String toDetailAccount(
                        @PathVariable("id") Long id,
                        Model model) {

                UserResponse response = userService.findAccountById(id);

                model.addAttribute(
                                "account",
                                response);

                return "cms/admin/account-detail";
        }

        @GetMapping("log")
        public String toLogList(
                        @PageableDefault(size = 20, sort = "createdAt", direction = Direction.DESC) Pageable pageable,
                        Model model) {

                model.addAttribute(
                                "logs",
                                auditLogService.getLogs(pageable));

                model.addAttribute(
                                "activeMenu",
                                "audit-log");

                return "cms/admin/audit-log";
        }

        @PostMapping("account/{id}/approve")
        public String approveAccount(
                        @PathVariable("id") Long id,
                        RedirectAttributes redirectAttributes) {

                userService.unlockUser(id);

                redirectAttributes.addFlashAttribute(
                                "successMessage",
                                "Duyệt tài khoản thành công");

                return "redirect:/admin/moonblight/account/" + id;
        }

        @PostMapping("account/{id}/reject")
        public String rejectAccount(
                        @PathVariable("id") Long id,
                        RedirectAttributes redirectAttributes) {

                userService.lockUser(id);

                redirectAttributes.addFlashAttribute(
                                "successMessage",
                                "Từ chối tài khoản thành công");

                return "redirect:/admin/moonblight/account/" + id;
        }

        @PostMapping("account/{id}/lock")
        public String lockAccount(
                        @PathVariable("id") Long id,
                        RedirectAttributes redirectAttributes) {

                userService.lockUser(id);

                redirectAttributes.addFlashAttribute(
                                "successMessage",
                                "Khóa tài khoản thành công");

                return "redirect:/admin/moonblight/account/" + id;
        }

        @PostMapping("account/{id}/unlock")
        public String unlockAccount(
                        @PathVariable("id") Long id,
                        RedirectAttributes redirectAttributes) {

                userService.unlockUser(id);

                redirectAttributes.addFlashAttribute(
                                "successMessage",
                                "Mở khóa tài khoản thành công");

                return "redirect:/admin/moonblight/account/" + id;
        }

}
