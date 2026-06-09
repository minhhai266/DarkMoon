package com.darkfantasy.dto.user;

import com.darkfantasy.annotation.ChangePasswordMatch;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@ChangePasswordMatch
public class ChangePasswordRequest {

    @NotBlank(message = "Mật khẩu cũ không được để trống")
    private String oldPassword;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 8, message = "Mật khẩu phải chứa ít nhất 8 kí tự")
    private String newPassword;

    @NotBlank(message = "Mật khẩu xác nhận không được để trống")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String confirmPassword;
}
