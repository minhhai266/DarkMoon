package com.darkfantasy.dto.story;

import com.darkfantasy.entity.Story;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class CreateStoryRequest {
    @NotBlank(message = "Tag không được để trống!")
    @Size(max = 255, message = "Tag không được vượt quá 255 ký tự!")
    private String tag;

    @NotBlank(message = "Tiêu đề không được để trống!")
    @Size(max = 255, message = "Tiêu đề không được vượt quá 255 ký tự!")
    private String title;
    @NotBlank(message = "Nội dung không được để trống!")
    private String content;
    private String image;
    @NotBlank(message = "Nội dung quote không được để trống!")
    private String quoteContent;
    @NotBlank(message = "Tác giả trích dẫn không được để trống!")
    private String quoteAuthor;
    @NotNull(message = "Độ ưu tiên không được để trống!")
    @Min(value = 0, message = "Độ ưu tiên phải từ 0 đến 100!")
    @Max(value = 100, message = "Độ ưu tiên phải từ 0 đến 100!")
    private Integer priority;

    public Story toEntity() {
        return Story.builder()
                .tag(this.tag)
                .title(this.title)
                .content(this.content)
                .image(this.image)
                .quoteContent(this.quoteContent)
                .quoteAuthor(this.quoteAuthor)
                .build();
    }
}
