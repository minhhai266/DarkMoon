package com.darkfantasy.dto.contributor;

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
public class UpdateContributorRequest {
    private Long id;
    @NotBlank(message = "Tên người đóng góp không được để trống")
    @Size(max = 255, message = "Tên người đóng góp không được vượt quá 255 ký tự")
    private String name;

    @NotBlank(message = "Chức danh không được để trống")
    @Size(max = 255, message = "Chức danh không được vượt quá 255 ký tự")
    private String position;

    private String avatar;

    @NotNull(message = "Độ ưu tiên không được để trống")
    @Min(value = 0, message = "Độ ưu tiên phải từ 0 đến 100")
    @Max(value = 100, message = "Độ ưu tiên phải từ 0 đến 100")
    private Integer priority;

}
