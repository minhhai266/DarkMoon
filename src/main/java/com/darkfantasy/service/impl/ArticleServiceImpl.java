package com.darkfantasy.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.darkfantasy.dto.article.ArticleResponse;
import com.darkfantasy.dto.article.CreateArticleRequest;
import com.darkfantasy.dto.article.UpdateArticleRequest;
import com.darkfantasy.entity.Article;
import com.darkfantasy.entity.User;
import com.darkfantasy.entity.enums.ArticleType;
import com.darkfantasy.repository.ArticleRepository;
import com.darkfantasy.repository.UserRepository;
import com.darkfantasy.service.ArticleService;
import com.darkfantasy.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    @Override
    public ArticleResponse getArticleById(Long id){ 
        return ArticleResponse.fromEntity(findArticle(id));
    }
    @Transactional
    @Override
    public ArticleResponse createArticle(CreateArticleRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Không thể tạo bài viết với dữ liệu null");
        }
        String currentUsername = SecurityUtil.getCurrentUserName();
        if (currentUsername == null) {
            throw new IllegalStateException("Không tìm thấy người dùng hiện tại");
        }
        User currentUser = userRepository
                .findUserByUsername(currentUsername)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy người dùng"));
        Article article = request.toEntity();
        article.setCreatedBy(currentUser);
        Article savedArticle = articleRepository.save(article);
        return ArticleResponse.fromEntity(savedArticle);
    }

    @Transactional
    @Override
    public ArticleResponse updateArticle(UpdateArticleRequest request) {
        Article article = findArticle(request.getId());
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
        article.setType(request.getType());
        article.setThumbnailUrl(request.getThumbnailUrl());

        return ArticleResponse.fromEntity(article);
    }

    @Transactional
    @Override
    public void deleteArticle(Long articleId) {
        if (articleId == null) {
            throw new IllegalArgumentException("Không thể xóa bài viết với ID null");
        }
        Article article = findArticle(articleId);
        article.setDeleted(true);
    }

    @Override
    public Page<ArticleResponse> getArticlesDeletedFalse(Pageable pageable) {
        return articleRepository
                .findByDeletedFalseOrderByCreatedAtDesc(pageable)
                .map(ArticleResponse::fromEntity);
    }

    @Override
    public List<ArticleResponse> getLatestArticles(int limit) {

        Pageable pageable = PageRequest.of(0, limit);

        return articleRepository
                .findByDeletedFalseOrderByCreatedAtDesc(pageable)
                .stream()
                .map(ArticleResponse::fromEntity)
                .toList();
    }

    @Override
    public ArticleResponse getLatestImportantArticle() {

        return articleRepository
                .findFirstByTypeAndDeletedFalseOrderByCreatedAtDesc(
                        ArticleType.IMPORTANT)
                .map(ArticleResponse::fromEntity)
                .orElse(null);
    }

    @Override
    public Page<ArticleResponse> getArticles(Pageable pageable) {
        if (pageable == null) {
            throw new IllegalArgumentException("Pageable không được null");
        }
        return articleRepository.findAll(pageable).map(ArticleResponse::fromEntity);
    }

    @Transactional
    @Override
    public void restoreArticle(Long articleId) {
        if (articleId == null) {
            throw new IllegalArgumentException("Không thể khôi phục bài viết với ID null");
        }
        Article article = findArticle(articleId);
        article.setDeleted(false);
    }

    private Article findArticle(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy bài viết với ID: " + id));
    }
}
