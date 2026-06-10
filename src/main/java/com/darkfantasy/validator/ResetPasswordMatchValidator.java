package com.darkfantasy.validator;

import com.darkfantasy.annotation.ResetPasswordMatch;
import com.darkfantasy.dto.user.ResetPasswordRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ResetPasswordMatchValidator
        implements ConstraintValidator<ResetPasswordMatch, ResetPasswordRequest> {

    @Override
    public boolean isValid(ResetPasswordRequest request,
            ConstraintValidatorContext context) {

        if (request.getNewPassword() == null
                || request.getConfirmPassword() == null) {
            return true;
        }

        boolean valid = request.getNewPassword()
                .equals(request.getConfirmPassword());

        if (!valid) {
            context.disableDefaultConstraintViolation();

            context.buildConstraintViolationWithTemplate(
                    "Mật khẩu xác nhận không khớp")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation();
        }

        return valid;
    }
}
