package com.darkfantasy.dto.world;

import com.darkfantasy.entity.World;

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
public class UpdateWorldRequest {
    private Long id;

    @NotBlank(message = "Tag không được để trống!")
    private String tag;
    @NotBlank(message = "Tiêu đề không được để trống!")
    @Size(max = 255, message = "Tiêu đề không được vượt quá 255 ký tự!")
    private String title;
    @NotBlank(message = "Nội dung không được để trống!")
    private String content;
    @NotNull(message = "Độ ưu tiên không được để trống!")
    @Min(value = 0, message = "Độ ưu tiên phải từ 0 đến 100!")
    @Max(value = 100, message = "Độ ưu tiên phải từ 0 đến 100!")
    private Integer priority;
    private String image;

    public World toEntity() {
        return World.builder()
                .id(this.id)
                .tag(this.tag)
                .title(this.title)
                .content(this.content)
                .priority(this.priority)
                .image(this.image)
                .build();
    }
}
