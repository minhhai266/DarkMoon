package com.darkfantasy.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.darkfantasy.constant.CmsMenu;
import com.darkfantasy.constant.Routes;
import com.darkfantasy.dto.faq.CreateFaqRequest;
import com.darkfantasy.dto.faq.FaqResponse;
import com.darkfantasy.dto.faq.UpdateFaqRequest;
import com.darkfantasy.service.FaqService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(Routes.FAQ + "/")
public class FaqController {
    private final FaqService faqService;

    @GetMapping({ "list", "list/" })
    public String toList(
            @PageableDefault(size = 10) Pageable pageable,
            Model model) {

        model.addAttribute(
                "faqs",
                faqService.getFaqs(pageable));
        model.addAttribute("activeMenu", CmsMenu.FAQ);
        return "cms/faq/faq-list";
    }

    @GetMapping({ "create", "create/" })
    public String toCreatePage(Model model) {
        model.addAttribute("createFaqRequest", new CreateFaqRequest());
        return "cms/faq/faq-create";
    }

    @PostMapping({ "create", "create/" })
    public String createFaq(
            @Valid @ModelAttribute("createFaqRequest") CreateFaqRequest request,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute(
                    "errorMessage",
                    "Vui lòng kiểm tra lại thông tin FAQ.");
            return "cms/faq/faq-create";
        }

        try {

            FaqResponse response = faqService.createFaq(request);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Tạo FAQ thành công: "
                            + response.getTitle());

            return "redirect:/faq/moonblight/list";

        } catch (Exception e) {

            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/faq/faq-create";
        }
    }

    @GetMapping({ "{id}/edit", "{id}/edit/" })
    public String toEditPage(@PathVariable("id") Long id, Model model) {
        FaqResponse faq = faqService.getFaqById(id);
        UpdateFaqRequest request = UpdateFaqRequest.builder()
                .id(faq.getId())
                .title(faq.getTitle())
                .content(faq.getContent())
                .priority(faq.getPriority())
                .build();

        model.addAttribute(
                "updateFaqRequest",
                request);
        model.addAttribute("faq", faq);
        return "cms/faq/faq-edit";
    }

    @PostMapping("{id}/edit")
    public String editFaq(@PathVariable Long id,
            @Valid @ModelAttribute("faq") UpdateFaqRequest request,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "cms/faq/faq-edit";
        }

        request.setId(id);

        try {
            faqService.updateFaq(request);

            return "redirect:/faq/moonblight/list";
        } catch (Exception e) {
            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/faq/faq-edit";
        }
    }

    @PostMapping("{id}/delete")
    public String deleteFaq(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            faqService.deleteFaq(id);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Xóa faq thành công");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());
        }

        return "redirect:/faq/moonblight/list";
    }

    @PostMapping("{id}/restore")
    public String restoreFaq(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            faqService.restoreFaq(id);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Khôi phục faq thành công");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());
        }

        return "redirect:/faq/moonblight/list";
    }
}
