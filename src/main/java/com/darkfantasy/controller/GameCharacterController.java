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
import com.darkfantasy.dto.gamecharacter.CreateGameCharacterRequest;
import com.darkfantasy.dto.gamecharacter.GameCharacterResponse;
import com.darkfantasy.dto.gamecharacter.UpdateGameCharacterRequest;
import com.darkfantasy.service.FileStorageService;
import com.darkfantasy.service.GameCharacterService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping(Routes.CHARACTER + "/")
@RequiredArgsConstructor
public class GameCharacterController {
    private final GameCharacterService gameCharacterService;
    private final FileStorageService fileStorageService;

    @GetMapping({ "list", "list/" })
    public String toList(
            @PageableDefault(size = 10) Pageable pageable,
            Model model) {

        model.addAttribute(
                "characters",
                gameCharacterService.getCharacters(pageable));
        model.addAttribute("activeMenu", CmsMenu.CHARACTER);
        return "cms/character/character-list";
    }

    @GetMapping({ "create", "create/" })
    public String toCreatePage(Model model) {
        model.addAttribute("createGameCharacterRequest", new CreateGameCharacterRequest());
        return "cms/character/character-create";
    }

    @PostMapping({ "create", "create/" })
    public String createCharacter(
            @Valid @ModelAttribute("createGameCharacterRequest") CreateGameCharacterRequest request,
            BindingResult result,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Vui lòng kiểm tra lại thông tin nhân vật.");
            return "cms/character/character-create";

        }
        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                request.setImage(fileStorageService.saveFile(imageFile, "characters"));
            }
            GameCharacterResponse response = gameCharacterService.createGameCharacter(request);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Tạo nhân vật thành công: "
                            + response.getName());
            return "redirect:/character/moonblight/list";
        } catch (Exception e) {
            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/character/character-create";
        }
    }

    @GetMapping({ "{id}/edit", "{id}/edit/" })
    public String toEditPage(@PathVariable("id") Long id, Model model) {
        GameCharacterResponse character = gameCharacterService.getGameCharacterById(id);
        model.addAttribute("character", character);
        return "cms/character/character-edit";
    }

    @PostMapping("{id}/edit")
    public String editCharacter(@PathVariable Long id,
            @Valid @ModelAttribute("character") UpdateGameCharacterRequest request,
            BindingResult result,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            Model model) {
        if (result.hasErrors()) {
            GameCharacterResponse oldCharacter = gameCharacterService.getGameCharacterById(id);

            request.setImage(
                    oldCharacter.getImage());

            return "cms/character/character-edit";
        }

        request.setId(id);

        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                request.setImage(
                        fileStorageService.saveFile(imageFile, "characters"));
            }
            gameCharacterService.updateGameCharacter(request);

            return "redirect:/character/moonblight/list";
        } catch (Exception e) {
            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/character/character-edit";
        }
    }

    @PostMapping("{id}/delete")
    public String deleteCharacter(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            gameCharacterService.deleteCharacter(id);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Xóa nhân vật thành công");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());
        }

        return "redirect:/character/moonblight/list";
    }

    @PostMapping("{id}/restore")
    public String restoreCharacter(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            gameCharacterService.restoreCharacter(id);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Khôi phục nhân vật thành công");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());
        }

        return "redirect:/character/moonblight/list";
    }

}
