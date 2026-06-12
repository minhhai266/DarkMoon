package com.darkfantasy.dto.article;

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
    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(max = 255)
    private String title;

    @NotBlank(message = "Nội dung không được để trống")
    private String content;

    private String thumbnailUrl;

    @NotNull(message = "Loại bài viết không được để trống")
    private ArticleType type;

}
