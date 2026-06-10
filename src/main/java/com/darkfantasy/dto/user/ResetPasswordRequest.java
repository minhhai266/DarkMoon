package com.darkfantasy.dto.user;

import com.darkfantasy.annotation.ResetPasswordMatch;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@ResetPasswordMatch
public class ResetPasswordRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String otp;

    @NotBlank
    @Size(min = 8)
    private String newPassword;

    @NotBlank
    private String confirmPassword;
}