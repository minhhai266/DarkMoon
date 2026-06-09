package com.darkfantasy.validator;

import com.darkfantasy.annotation.ChangePasswordMatch;
import com.darkfantasy.dto.user.ChangePasswordRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordChangeMatchValidator implements ConstraintValidator<ChangePasswordMatch, ChangePasswordRequest>{

    @Override
    public boolean isValid(ChangePasswordRequest request,
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
