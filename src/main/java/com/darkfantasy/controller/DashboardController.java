package com.darkfantasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.RouteMatcher.Route;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.darkfantasy.constant.CmsMenu;
import com.darkfantasy.constant.Routes;
import com.darkfantasy.service.ArticleService;
import com.darkfantasy.service.ContactMessageService;
import com.darkfantasy.service.ContributorService;
import com.darkfantasy.service.FaqService;
import com.darkfantasy.service.GameCharacterService;
import com.darkfantasy.service.StoryService;
import com.darkfantasy.service.WorldService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(Routes.DASHBOARD)

public class DashboardController {
        private final ArticleService articleService;
        private final GameCharacterService gameCharacterService;
        private final WorldService worldService;
        private final StoryService storyService;
        private final FaqService faqService;
        private final ContributorService contributorService;
        private final ContactMessageService contactMessageService;

        @GetMapping({ "", "/" })
        public String toDashboard(Model model) {
                model.addAttribute("activeMenu", CmsMenu.DASHBOARD);
                model.addAttribute("articleCount", articleService.count());
                model.addAttribute("storyCount", storyService.count());
                model.addAttribute("worldCount", worldService.count());
                model.addAttribute("characterCount", gameCharacterService.count());
                model.addAttribute("faqCount", faqService.count());
                model.addAttribute("contributorCount", contributorService.count());
                model.addAttribute("unprocessedContactCount", contactMessageService.countByProcessedFalse());
                return "cms/dashboard";
        }
}
