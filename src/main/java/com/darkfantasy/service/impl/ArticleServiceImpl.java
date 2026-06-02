package com.darkfantasy.service.impl;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.darkfantasy.dto.article.ArticleResponse;
import com.darkfantasy.dto.article.CreateArticleRequest;
import com.darkfantasy.dto.article.UpdateArticleRequest;
import com.darkfantasy.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

    @Override
    public ArticleResponse createArticle(CreateArticleRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Không thể tạo bài viết với dữ liệu null");
        }
        return ArticleResponse.builder()
                .id(1L)
                .title(request.getTitle())
                .content(request.getContent())
                .authorUsername("Tác giả 1")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Override
    public ArticleResponse getArticleById(Long articleId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getArticleById'");
    }

    @Override
    public ArticleResponse updateArticle(UpdateArticleRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateArticle'");
    }

    @Override
    public void deleteArticle(Long articleId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteArticle'");
    }

    @Override
    public Page<ArticleResponse> getArticles(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getArticles'");
    }

}
