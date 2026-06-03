package com.darkfantasy.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

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

import com.darkfantasy.dto.article.ArticleResponse;
import com.darkfantasy.dto.article.CreateArticleRequest;
import com.darkfantasy.dto.article.UpdateArticleRequest;
import com.darkfantasy.entity.enums.ArticleType;
import com.darkfantasy.service.ArticleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/article/moonblight/")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping({ "/list", "/list/" })
    public String articleList(
            @PageableDefault(size = 10) Pageable pageable,
            Model model) {

        model.addAttribute(
                "articles",
                articleService.getArticles(pageable));

        return "article/article-list";
    }

    @GetMapping({ "/create", "/create/" })
    public String toCreatePage(Model model) {
        model.addAttribute("articleTypes", ArticleType.values());
        return "article/article-create";
    }

    @PostMapping("/create")
    public String createArticle(
            @Valid @ModelAttribute CreateArticleRequest request,
            BindingResult result,
            @RequestParam("thumbnail") MultipartFile thumbnailFile,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "article/article-create";
        }

        try {

            if (!thumbnailFile.isEmpty()) {

                String fileName = UUID.randomUUID()
                        + "_"
                        + thumbnailFile.getOriginalFilename();

                Path uploadDir = Paths.get("uploads/articles");

                Files.createDirectories(uploadDir);

                thumbnailFile.transferTo(
                        uploadDir.resolve(fileName));

                request.setThumbnailUrl(
                        "/uploads/articles/" + fileName);
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

            return "article/article-create";
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

    @GetMapping("/{id}/edit")
    public String editArticlePage(
            @PathVariable Long id,
            Model model) {

        ArticleResponse article = articleService.getArticleById(id);

        model.addAttribute("article", article);
        model.addAttribute("articleTypes", ArticleType.values());

        return "article/article-edit";
    }

    @PostMapping("/{id}/edit")
    public String updateArticle(
            @PathVariable Long id,
            @Valid @ModelAttribute("article") UpdateArticleRequest request,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("articleTypes", ArticleType.values());
            return "article/article-edit";
        }

        request.setId(id);

        articleService.updateArticle(request);

        return "redirect:/article/moonblight/list";
    }
}
