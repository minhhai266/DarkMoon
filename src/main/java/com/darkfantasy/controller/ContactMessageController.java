package com.darkfantasy.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.darkfantasy.constant.CmsMenu;
import com.darkfantasy.constant.Routes;
import com.darkfantasy.service.ContactMessageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(Routes.CONTACT + "/")
public class ContactMessageController {
    private final ContactMessageService contactMessageService;

    @GetMapping("list")
    public String toList(
            @PageableDefault(size = 20) Pageable pageable,
            Model model) {
        model.addAttribute("messages", contactMessageService.getMessages(pageable));
        model.addAttribute("activeMenu", CmsMenu.CONTACT);

        return "cms/contact/contact-list";
    }

    @GetMapping("{id}")
    public String detail(
            @PathVariable Long id,
            Model model) {

        model.addAttribute("message", contactMessageService.getMessageById(id));
        model.addAttribute("activeMenu", CmsMenu.CONTACT);
        return "cms/contact/contact-detail";
    }

    @PostMapping("{id}/process")
    public String process(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        contactMessageService.markAsProcessed(id);
        redirectAttributes.addFlashAttribute("successMessage", "Đã đánh dấu xử lý.");
        return "redirect:/contact/blightmoon/list";
    }

    @PostMapping("{id}/unprocess")
    public String unprocess(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {

        contactMessageService.markAsUnprocessed(id);

        redirectAttributes.addFlashAttribute("successMessage", "Đã đánh dấu chưa xử lý.");

        return "redirect:/contact/blightmoon/list";
    }
}
