package com.darkfantasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("activePage", "home");
        model.addAttribute("pageTitle", "Moon Blight - Enter the Darkness");
        return "index";
    }

    @GetMapping("/story")
    public String story(Model model) {
        model.addAttribute("activePage", "story");
        model.addAttribute("pageTitle", "The Story - Moon Blight");
        return "storys/story";
    }

    @GetMapping("/characters")
    public String characters(Model model) {
        model.addAttribute("activePage", "characters");
        model.addAttribute("pageTitle", "Characters - Moon Blight");
        return "characters/characters";
    }

    @GetMapping("/enemies")
    public String enemies(Model model) {
        model.addAttribute("activePage", "enemies");
        model.addAttribute("pageTitle", "Enemies - Moon Blight");
        return "enemies/enemies";
    }

    @GetMapping("/weapons")
    public String weapons(Model model) {
        model.addAttribute("activePage", "weapons");
        model.addAttribute("pageTitle", "Weapons - Moon Blight");
        return "weapons/weapons";
    }

    @GetMapping("/world")
    public String world(Model model) {
        model.addAttribute("activePage", "world");
        model.addAttribute("pageTitle", "The World - Moon Blight");
        return "worlds/world";
    }

    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("activePage", "news");
        model.addAttribute("pageTitle", "News - Moon Blight");
        return "news/news";
    }

    @GetMapping("/aboutUs")
    public String community(Model model) {
        model.addAttribute("activePage", "community");
        model.addAttribute("pageTitle", "Community - Moon Blight");
        return "community/aboutUs";
    }

    @GetMapping("/support")
    public String support(Model model) {
        model.addAttribute("activePage", "support");
        model.addAttribute("pageTitle", "Support - Moon Blight");
        return "supports/support";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("activePage", "login");
        model.addAttribute("pageTitle", "Login - Moon Blight");
        return "auths/login";
    }
}
