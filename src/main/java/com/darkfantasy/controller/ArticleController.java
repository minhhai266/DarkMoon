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
import com.darkfantasy.dto.article.ArticleResponse;
import com.darkfantasy.dto.article.CreateArticleRequest;
import com.darkfantasy.dto.article.UpdateArticleRequest;
import com.darkfantasy.entity.enums.ArticleType;
import com.darkfantasy.service.ArticleService;
import com.darkfantasy.service.FileStorageService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(Routes.ARTICLE + "/")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final FileStorageService fileStorageService;

    @ModelAttribute("articleTypes")
    public ArticleType[] articleTypes() {
        return ArticleType.values();
    }

    @GetMapping({ "/list", "/list/" })
    public String articleList(
            @PageableDefault(size = 10) Pageable pageable,
            Model model) {
        model.addAttribute(
                "articles",
                articleService.getArticles(pageable));
        model.addAttribute("activeMenu", CmsMenu.ARTICLE);
        return "cms/article/article-list";
    }

    @GetMapping({ "/create", "/create/" })
    public String toCreatePage(Model model) {
        model.addAttribute("createArticleRequest", new CreateArticleRequest());
        return "cms/article/article-create";
    }

    @PostMapping("/create")
    public String createArticle(
            @Valid @ModelAttribute("createArticleRequest") CreateArticleRequest request,
            BindingResult result,
            @RequestParam("thumbnail") MultipartFile thumbnailFile,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "cms/article/article-create";
        }

        try {

            if (!thumbnailFile.isEmpty()) {
                request.setThumbnailUrl(fileStorageService.saveFile(thumbnailFile, "articles"));
            }

            ArticleResponse response = articleService.createArticle(request);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Tạo bài viết thành công: "
                            + response.getTitle());

            return "redirect:/article/moonblight/list";

        } catch (Exception e) {

            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/article/article-create";
        }
    }

    @PostMapping("{id}/delete")
    public String deleteArticle(
            @PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {

        try {
            articleService.deleteArticle(id);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Xóa bài viết thành công");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());
        }

        return "redirect:/article/moonblight/list";
    }

    @PostMapping("{id}/restore")
    public String restoreArticle(
            @PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        try {
            articleService.restoreArticle(id);
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Khôi phục bài viết thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());
        }
        return "redirect:/article/moonblight/list";
    }

    @GetMapping({ "/{id}/edit", "/{id}/edit/" })
    public String editArticlePage(
            @PathVariable Long id,
            Model model) {

        ArticleResponse article = articleService.getArticleById(id);

        model.addAttribute("article", article);

        return "cms/article/article-edit";
    }

    @PostMapping("/{id}/edit")
    public String editArticle(
            @PathVariable Long id,
            @Valid @ModelAttribute("article") UpdateArticleRequest request,
            BindingResult result,
            @RequestParam("thumbnail") MultipartFile thumbnailFile,
            Model model) {

        if (result.hasErrors()) {
            ArticleResponse oldArticle = articleService.getArticleById(id);

            request.setThumbnailUrl(
                    oldArticle.getThumbnailUrl());

            model.addAttribute(
                    "articleTypes",
                    ArticleType.values());

            return "cms/article/article-edit";
        }

        request.setId(id);

        try {

            if (!thumbnailFile.isEmpty()) {

                request.setThumbnailUrl(
                        fileStorageService.saveFile(thumbnailFile, "articles"));
            }

            articleService.updateArticle(request);

            return "redirect:/article/moonblight/list";

        } catch (Exception e) {

            model.addAttribute(
                    "articleTypes",
                    ArticleType.values());

            model.addAttribute(
                    "errorMessage",
                    e.getMessage());

            return "cms/article/article-edit";
        }
    }

}
