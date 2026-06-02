package com.darkfantasy.dto.article;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.darkfantasy.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ArticleResponse {
    private Long id;
    private String title;
    private String content;
    private String authorUsername;
    private String thumbnailUrl;
    private String type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Article toEntity() {
        return Article.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .thumbnailUrl(this.thumbnailUrl)
                .type(this.type)
                .build();
    }

    public static ArticleResponse fromEntity(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .authorUsername(article.getCreatedBy().getUsername())
                .thumbnailUrl(article.getThumbnailUrl())
                .type(article.getType())
                .createdAt(article.getCreatedAt().atZone(ZoneId.systemDefault()).toLocalDateTime())
                .updatedAt(article.getUpdatedAt().atZone(ZoneId.systemDefault()).toLocalDateTime())
                .build();
    }
}
