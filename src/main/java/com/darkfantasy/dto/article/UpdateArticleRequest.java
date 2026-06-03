package com.darkfantasy.dto.article;

import com.darkfantasy.entity.Article;
import com.darkfantasy.entity.enums.ArticleType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateArticleRequest {
    @NotNull
    private Long id;
    @NotBlank
    @Size(max = 255)
    private String title;

    @NotBlank
    private String content;

    private String thumbnailUrl;

    @NotNull
    private ArticleType type;

}
