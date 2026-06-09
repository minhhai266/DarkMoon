package com.darkfantasy.validator;

import com.darkfantasy.annotation.RegisterPasswordMatch;
import com.darkfantasy.dto.user.RegisterRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordRegisterMatchValidator
        implements ConstraintValidator<RegisterPasswordMatch, RegisterRequest> {

    @Override
    public boolean isValid(RegisterRequest request,
            ConstraintValidatorContext context) {

        if (request.getPassword() == null
                || request.getRePassword() == null) {
            return true;
        }

        boolean valid = request.getPassword()
                .equals(request.getRePassword());

        if (!valid) {
            context.disableDefaultConstraintViolation();

            context.buildConstraintViolationWithTemplate(
                    "Mật khẩu xác nhận không khớp")
                    .addPropertyNode("rePassword")
                    .addConstraintViolation();
        }

        return valid;
    }
}