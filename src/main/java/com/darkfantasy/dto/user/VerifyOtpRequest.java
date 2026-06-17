package com.darkfantasy.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VerifyOtpRequest {

    @NotBlank
    private String email;

    @NotBlank(message = "OTP không được trống")
    private String otp;
}