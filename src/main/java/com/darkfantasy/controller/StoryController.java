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
import com.darkfantasy.dto.story.CreateStoryRequest;
import com.darkfantasy.dto.story.StoryResponse;
import com.darkfantasy.dto.story.UpdateStoryRequest;
import com.darkfantasy.service.FileStorageService;
import com.darkfantasy.service.StoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(Routes.STORY + "/")
public class StoryController {
    private final StoryService storyService;
    private final FileStorageService fileStorageService;

    @GetMapping({ "list", "list/" })
    public String toList(
            @PageableDefault(size = 10) Pageable pageable,
            Model model) {

        model.addAttribute(
                "stories",
                storyService.getStories(pageable));
        model.addAttribute("activeMenu", CmsMenu.STORY);
        return "cms/story/story-list";
    }

    @GetMapping({ "create", "create/" })
    public String toCreatePage(Model model) {
        model.addAttribute("createStoryRequest", new CreateStoryRequest());
        return "cms/story/story-create";
    }

    @PostMapping({ "create", "create/" })
    public String createStory(
            @Valid @ModelAttribute("createStoryRequest") CreateStoryRequest request,
            BindingResult result,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "cms/story/story-create";

        }
        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                request.setImage(fileStorageService.saveFile(imageFile, "stories"));
            }
            StoryResponse response = storyService.createStory(request);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Tạo câu chuyện thành công: "
                            + response.getTitle());
            return "redirect:/story/moonblight/list";
        } catch (Exception e) {
            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/story/story-create";
        }
    }

    @GetMapping({ "{id}/edit", "{id}/edit/" })
    public String toEditPage(@PathVariable("id") Long id, Model model) {
        StoryResponse story = storyService.getStoryById(id);

        model.addAttribute("story", story);
        return "cms/story/story-edit";
    }

    @PostMapping("{id}/edit")
    public String editStory(@PathVariable Long id,
            @Valid @ModelAttribute("story") UpdateStoryRequest request,
            BindingResult result,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            Model model) {
        if (result.hasErrors()) {
            StoryResponse oldStory = storyService.getStoryById(id);

            request.setImage(
                    oldStory.getImage());

            return "cms/story/story-edit";
        }

        request.setId(id);

        try {
            StoryResponse oldStory = storyService.getStoryById(id);

            if (imageFile != null && !imageFile.isEmpty()) {

                request.setImage(
                        fileStorageService.saveFile(
                                imageFile,
                                "stories"));

            } else {
                request.setImage(
                        oldStory.getImage());
            }
            storyService.updateStory(request);

            return "redirect:/story/moonblight/list";
        } catch (Exception e) {
            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/story/story-edit";
        }
    }

    @PostMapping("{id}/delete")
    public String deleteStory(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            storyService.deleteStory(id);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Xóa câu chuyện thành công");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());
        }

        return "redirect:/story/moonblight/list";
    }

    @PostMapping("{id}/restore")
    public String restoreStory(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            storyService.restoreStory(id);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Khôi phục câu chuyện thành công");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());
        }

        return "redirect:/story/moonblight/list";
    }
}
