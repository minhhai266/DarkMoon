package com.darkfantasy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.darkfantasy.dto.article.ArticleResponse;
import com.darkfantasy.dto.article.CreateArticleRequest;
import com.darkfantasy.dto.article.UpdateArticleRequest;

public interface ArticleService {
    ArticleResponse createArticle(CreateArticleRequest request);
    ArticleResponse getArticleById(Long articleId);
    ArticleResponse updateArticle(UpdateArticleRequest request);
    void deleteArticle(Long articleId);

    Page<ArticleResponse> getArticles(Pageable pageable);
}
