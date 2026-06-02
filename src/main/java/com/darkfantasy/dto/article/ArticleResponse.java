package com.darkfantasy.dto.article;

import com.darkfantasy.entity.Article;
import com.darkfantasy.entity.enums.ArticleType;
import com.darkfantasy.util.TimeUtil;

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
    private String createdAt;
    private String updatedAt;
    private boolean deleted;

    public static ArticleResponse fromEntity(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .authorUsername(article.getCreatedBy().getUsername())
                .thumbnailUrl(article.getThumbnailUrl())
                .type(article.getType().getDisplayName())
                .createdAt(TimeUtil.formatInstant(article.getCreatedAt()))
                .updatedAt(TimeUtil.formatInstant(article.getUpdatedAt()))
                .deleted(article.isDeleted())
                .build();
    }

    public String getSummary() {
        if (content == null) {
            return "";
        }

        if (content.length() <= 150) {
            return content;
        }

        return content.substring(0, 150) + "...";
    }
}
