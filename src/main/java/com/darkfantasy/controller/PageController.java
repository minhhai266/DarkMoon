package com.darkfantasy.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.darkfantasy.dto.article.ArticleResponse;
import com.darkfantasy.dto.contact.CreateContactMessageRequest;
import com.darkfantasy.entity.enums.ContactCategory;
import com.darkfantasy.entity.enums.ContactPlatform;
import com.darkfantasy.service.ArticleService;
import com.darkfantasy.service.ContactMessageService;
import com.darkfantasy.service.FaqService;
import com.darkfantasy.service.GameCharacterService;
import com.darkfantasy.service.StoryService;
import com.darkfantasy.service.WorldService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class PageController {
    private final ArticleService articleService;
    private final GameCharacterService gameCharacterService;
    private final WorldService worldService;
    private final StoryService storyService;
    private final FaqService faqService;
    private final ContactMessageService contactMessageService;

    @GetMapping
    public String index(Model model) {

        model.addAttribute("activePage", "home");
        model.addAttribute("pageTitle", "Moon Blight - Enter the Darkness");

        model.addAttribute("articles", articleService.getLatestArticles(3));
        model.addAttribute("characters", gameCharacterService.getCharactersLimit(4));
        model.addAttribute("topWorld", worldService.getWorldDeletedFalseHighestPriority());
        model.addAttribute("topStory", storyService.getStoryDeletedFalseHighestPriority());

        return "forward:/WEB-INF/views/index.jsp";
        // return "index";
    }

    @GetMapping("story")
    public String story(Model model) {
        model.addAttribute("activePage", "story");
        model.addAttribute("pageTitle", "The Story - Moon Blight");

        model.addAttribute("stories", storyService.getStoriesDeletedFalse());
        return "forward:/WEB-INF/views/storys/story.jsp";
        // return "story/story";
    }

    @GetMapping("characters")
    public String characters(Model model) {
        model.addAttribute("activePage", "characters");
        model.addAttribute("pageTitle", "Characters - Moon Blight");

        model.addAttribute("characters", gameCharacterService.getCharactersDeletedFalse());
        return "forward:/WEB-INF/views/characters/characters.jsp";
    }

    @GetMapping("enemies")
    public String enemies(Model model) {
        model.addAttribute("activePage", "enemies");
        model.addAttribute("pageTitle", "Enemies - Moon Blight");
        return "forward:/WEB-INF/views/enemies/enemies.jsp";
    }

    @GetMapping("weapons")
    public String weapons(Model model) {
        model.addAttribute("activePage", "weapons");
        model.addAttribute("pageTitle", "Weapons - Moon Blight");
        return "forward:/WEB-INF/views/weapons/weapons.jsp";
    }

    @GetMapping("world")
    public String world(Model model) {

        model.addAttribute("activePage", "world");
        model.addAttribute("pageTitle", "The World - Moon Blight");

        model.addAttribute("worlds", worldService.getWorldsDeletedFalse());

        return "forward:/WEB-INF/views/worlds/world.jsp";
    }

    @GetMapping("news")
    public String news(
            @RequestParam(defaultValue = "6") int limit,
            Model model) {

        Pageable pageable = PageRequest.of(0, limit);

        Page<ArticleResponse> page = articleService.getArticlesDeletedFalse(pageable);

        model.addAttribute(
                "articles",
                page.getContent());

        model.addAttribute(
                "hasMore",
                page.getTotalElements() > limit);

        model.addAttribute(
                "nextLimit",
                limit + 6);
        model.addAttribute(
                "featuredArticle",
                articleService.getLatestImportantArticle());

        return "forward:/WEB-INF/views/news/news.jsp";
    }

    @GetMapping("aboutUs")
    public String community(Model model) {
        model.addAttribute("activePage", "community");
        model.addAttribute("pageTitle", "Community - Moon Blight");
        return "forward:/WEB-INF/views/community/aboutUs.jsp";
    }

    @GetMapping("news/{id}")
    public String newsDetail(@PathVariable("id") Long id,
            Model model) {
        model.addAttribute("article", articleService.getPublicArticleById(id));
        model.addAttribute("articles", articleService.getLatestArticlesExcept(id, 3));
        return "forward:/WEB-INF/views/news/newDetail.jsp";
    }

    @GetMapping("support")
    public String support(Model model) {
        populateSupportModel(model);
        model.addAttribute("contactRequest", new CreateContactMessageRequest());
        return "forward:/WEB-INF/views/supports/support.jsp";
    }

    @PostMapping("support")
    public String submitContactMessage(
            @Valid @ModelAttribute("contactRequest") CreateContactMessageRequest request,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            populateSupportModel(model);
            model.addAttribute("errorMessage", "Vui lòng kiểm tra lại thông tin liên hệ.");
            return "forward:/WEB-INF/views/supports/support.jsp";
        }

        contactMessageService.createMessage(request);

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Tin nhắn đã được gửi thành công.");

        return "redirect:/support";
    }

    private void populateSupportModel(Model model) {
        model.addAttribute("activePage", "support");
        model.addAttribute("pageTitle", "Support - Moon Blight");
        model.addAttribute("faqs", faqService.getFaqsDeletedFalse());
        model.addAttribute("categories", ContactCategory.values());
        model.addAttribute("platforms", ContactPlatform.values());
    }
}
