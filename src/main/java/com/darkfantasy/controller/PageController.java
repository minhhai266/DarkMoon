package com.darkfantasy.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.darkfantasy.dto.article.ArticleResponse;
import com.darkfantasy.service.ArticleService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final ArticleService articleService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("activePage", "home");
        model.addAttribute(
                "pageTitle",
                "Moon Blight - Enter the Darkness");

        model.addAttribute(
                "articles",
                articleService.getLatestArticles(3));

        return "forward:/WEB-INF/views/index.jsp";
        // return "index";
    }

    @GetMapping("/story")
    public String story(Model model) {
        model.addAttribute("activePage", "story");
        model.addAttribute("pageTitle", "The Story - Moon Blight");
        return "forward:/WEB-INF/views/storys/story.jsp";
        // return "story/story";
    }

    @GetMapping("/characters")
    public String characters(Model model) {
        model.addAttribute("activePage", "characters");
        model.addAttribute("pageTitle", "Characters - Moon Blight");
        return "forward:/WEB-INF/views/characters/characters.jsp";
    }

    @GetMapping("/enemies")
    public String enemies(Model model) {
        model.addAttribute("activePage", "enemies");
        model.addAttribute("pageTitle", "Enemies - Moon Blight");
        return "forward:/WEB-INF/views/enemies/enemies.jsp";
    }

    @GetMapping("/weapons")
    public String weapons(Model model) {
        model.addAttribute("activePage", "weapons");
        model.addAttribute("pageTitle", "Weapons - Moon Blight");
        return "forward:/WEB-INF/views/weapons/weapons.jsp";
    }

    @GetMapping("/world")
    public String world(Model model) {
        model.addAttribute("activePage", "world");
        model.addAttribute("pageTitle", "The World - Moon Blight");
        return "forward:/WEB-INF/views/worlds/world.jsp";
    }

    @GetMapping("/news")
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

    @GetMapping("/aboutUs")
    public String community(Model model) {
        model.addAttribute("activePage", "community");
        model.addAttribute("pageTitle", "Community - Moon Blight");
        return "forward:/WEB-INF/views/community/aboutUs.jsp";
    }

    @GetMapping("/support")
    public String support(Model model) {
        model.addAttribute("activePage", "support");
        model.addAttribute("pageTitle", "Support - Moon Blight");
        return "forward:/WEB-INF/views/supports/support.jsp";
    }
}
