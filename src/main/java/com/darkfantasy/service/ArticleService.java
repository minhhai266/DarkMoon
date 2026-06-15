package com.darkfantasy.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.darkfantasy.dto.article.ArticleResponse;
import com.darkfantasy.dto.article.CreateArticleRequest;
import com.darkfantasy.dto.article.UpdateArticleRequest;

public interface ArticleService {
    ArticleResponse getArticleById(Long id);

    ArticleResponse getPublicArticleById(Long id); // Website

    ArticleResponse createArticle(CreateArticleRequest request);

    ArticleResponse updateArticle(UpdateArticleRequest request);

    void deleteArticle(Long articleId);

    void restoreArticle(Long articleId);

    Page<ArticleResponse> getArticles(Pageable pageable);

    Page<ArticleResponse> getArticlesDeletedFalse(Pageable pageable);

    List<ArticleResponse> getLatestArticles(int limit);

    List<ArticleResponse> getLatestArticlesExcept(Long id, int limit);

    ArticleResponse getLatestImportantArticle();

    long count();

}
