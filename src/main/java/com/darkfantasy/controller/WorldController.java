package com.darkfantasy.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.darkfantasy.constant.CmsMenu;
import com.darkfantasy.constant.Routes;
import com.darkfantasy.dto.world.CreateWorldRequest;
import com.darkfantasy.dto.world.UpdateWorldRequest;
import com.darkfantasy.dto.world.WorldResponse;
import com.darkfantasy.service.FileStorageService;
import com.darkfantasy.service.WorldService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(Routes.WORLD + "/")
public class WorldController {
    private final WorldService worldService;
    private final FileStorageService fileStorageService;

    @GetMapping({ "list", "list/" })
    public String toList(
            @PageableDefault(size = 10) Pageable pageable,
            Model model) {

        model.addAttribute(
                "worlds",
                worldService.getWorlds(pageable));
        model.addAttribute("activeMenu", CmsMenu.WORLD);
        return "cms/world/world-list";
    }

    @GetMapping({ "create", "create/" })
    public String toCreatePage(Model model) {
        model.addAttribute("createWorldRequest", new CreateWorldRequest());
        return "cms/world/world-create";
    }

    @PostMapping({ "create", "create/" })
    public String createWorld(
            @Valid @ModelAttribute("createWorldRequest") CreateWorldRequest request,
            BindingResult result,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Vui lòng kiểm tra lại thông tin thế giới.");
            return "cms/world/world-create";

        }
        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                request.setImage(fileStorageService.saveFile(imageFile, "worlds"));
            }
            WorldResponse response = worldService.createWorld(request);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Tạo thế giới thành công: "
                            + response.getTitle());
            return "redirect:/world/moonblight/list";
        } catch (Exception e) {
            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/world/world-create";
        }
    }

    @GetMapping({ "{id}/edit", "{id}/edit/" })
    public String toEditPage(@PathVariable("id") Long id, Model model) {
        WorldResponse world = worldService.getWorldById(id);
        model.addAttribute("world", world);
        return "cms/world/world-edit";
    }

    @PostMapping("{id}/edit")
    public String editWorld(@PathVariable Long id,
            @Valid @ModelAttribute("world") UpdateWorldRequest request,
            BindingResult result,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            Model model) {
        if (result.hasErrors()) {
            WorldResponse oldWorld = worldService.getWorldById(id);

            request.setImage(
                    oldWorld.getImage());

            return "cms/world/world-edit";
        }

        request.setId(id);

        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                request.setImage(
                        fileStorageService.saveFile(imageFile, "worlds"));
            }
            worldService.updateWorld(request);

            return "redirect:/world/moonblight/list";
        } catch (Exception e) {
            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/world/world-edit";
        }
    }

    @PostMapping("{id}/delete")
    public String deleteWorld(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            worldService.deleteWorld(id);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Xóa thế giới thành công");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());
        }

        return "redirect:/world/moonblight/list";
    }

    @PostMapping("{id}/restore")
    public String restoreWorld(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            worldService.restoreWorld(id);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Khôi phục thế giới thành công");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());
        }

        return "redirect:/world/moonblight/list";
    }
}
