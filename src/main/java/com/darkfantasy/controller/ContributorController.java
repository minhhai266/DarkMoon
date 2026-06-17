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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.darkfantasy.constant.CmsMenu;
import com.darkfantasy.constant.Routes;
import com.darkfantasy.dto.contributor.ContributorResponse;
import com.darkfantasy.dto.contributor.CreateContributorRequest;
import com.darkfantasy.dto.contributor.UpdateContributorRequest;
import com.darkfantasy.service.ContributorService;
import com.darkfantasy.service.FileStorageService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(Routes.CONTRIBUTOR + "/")
@RequiredArgsConstructor
public class ContributorController {

    private final ContributorService contributorService;
    private final FileStorageService fileStorageService;

    @GetMapping({ "/list", "/list/" })
    public String contributorList(
            @PageableDefault(size = 10) Pageable pageable,
            Model model) {
        model.addAttribute(
                "contributors",
                contributorService.getContributors(pageable));
        model.addAttribute("activeMenu", CmsMenu.CONTRIBUTOR);
        return "cms/contributor/contributor-list";
    }

    @GetMapping({ "/create", "/create/" })
    public String toCreatePage(Model model) {
        model.addAttribute("createContributorRequest", new CreateContributorRequest());
        return "cms/contributor/contributor-create";
    }

    @PostMapping("/create")
    public String createContributor(
            @Valid @ModelAttribute("createContributorRequest") CreateContributorRequest request,
            BindingResult result,
            @RequestParam("thumbnail") MultipartFile thumbnailFile,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "cms/contributor/contributor-create";
        }

        try {

            if (!thumbnailFile.isEmpty()) {
                request.setAvatar(fileStorageService.saveFile(thumbnailFile, "contributors"));
            }

            ContributorResponse response = contributorService.createContributor(request);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Tạo người đóng góp thành công: "
                            + response.getName());

            return "redirect:" + Routes.CONTRIBUTOR + "/list";

        } catch (Exception e) {

            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/contributor/contributor-create";
        }
    }

    @PostMapping("{id}/delete")
    public String deleteContributor(
            @PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {

        try {
            contributorService.deleteContributor(id);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Xóa người đóng góp thành công");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());
        }

        return "redirect:" + Routes.CONTRIBUTOR + "/list";
    }

    @PostMapping("{id}/restore")
    public String restoreContributor(
            @PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        try {
            contributorService.restoreContributor(id);
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Khôi phục người đóng góp thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());
        }
        return "redirect:" + Routes.CONTRIBUTOR + "/list";
    }

    @GetMapping({ "/{id}/edit", "/{id}/edit/" })
    public String editContributorPage(
            @PathVariable Long id,
            Model model) {

        ContributorResponse contributor = contributorService.getContributorById(id);

        model.addAttribute("contributor", contributor);

        return "cms/contributor/contributor-edit";
    }

    @PostMapping("/{id}/edit")
    public String editContributor(
            @PathVariable Long id,
            @Valid @ModelAttribute("contributor") UpdateContributorRequest request,
            BindingResult result,
            @RequestParam("thumbnail") MultipartFile thumbnailFile,
            Model model) {

        if (result.hasErrors()) {
            ContributorResponse oldContributor = contributorService.getContributorById(id);

            request.setAvatar(
                    oldContributor.getAvatar());

            return "cms/contributor/contributor-edit";
        }

        request.setId(id);

        try {

            if (!thumbnailFile.isEmpty()) {

                request.setAvatar(
                        fileStorageService.saveFile(thumbnailFile, "contributors"));
            }

            contributorService.updateContributor(request);

            return "redirect:" + Routes.CONTRIBUTOR + "/list";

        } catch (Exception e) {

            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/contributor/contributor-edit";
        }
    }

}
