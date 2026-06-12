package com.darkfantasy.dto.gamecharacter;

import com.darkfantasy.entity.GameCharacter;

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
public class UpdateGameCharacterRequest {
    private Long id;
    @NotBlank(message = "Tên nhân vật không được để trống")
    @Size(max = 255, message = "Tên nhân vật không được vượt quá 255 ký tự")
    private String name;
    @NotBlank(message = "Chủng tộc không được để trống")
    @Size(max = 100, message = "Chủng tộc không được vượt quá 100 ký tự")
    private String race;
    @NotBlank(message = "Mô tả không được để trống")
    private String description;
    @Size(max = 255, message = "Quote không được vượt quá 255 ký tự")
    private String quote;
    private String image;
    @NotNull(message = "Độ ưu tiên không được để trống")
    @Min(value = 0, message = "Độ ưu tiên phải từ 0 đến 100")
    @Max(value = 100, message = "Độ ưu tiên phải từ 0 đến 100")
    private Integer priority;

    public GameCharacter toEntity() {
        return GameCharacter.builder()
                .id(this.id)
                .name(this.name)
                .race(this.race)
                .description(this.description)
                .quote(this.quote)
                .image(this.image)
                .priority(this.priority)
                .build();
    }
}
