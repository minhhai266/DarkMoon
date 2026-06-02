package com.darkfantasy.dto.article;

import com.darkfantasy.entity.Article;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateArticleRequest {

    @NotBlank
    @Size(max = 255)
    private String title;

    @NotBlank
    private String content;

    private String thumbnailUrl;

    @NotBlank
    private String type;

    public Article toEntity() {
        return Article.builder()
                .title(this.title)
                .content(this.content)
                .thumbnailUrl(this.thumbnailUrl)
                .type(this.type)
                .build();
    }
}