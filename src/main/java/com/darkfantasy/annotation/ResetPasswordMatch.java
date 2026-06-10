package com.darkfantasy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.darkfantasy.validator.ResetPasswordMatchValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ResetPasswordMatchValidator.class)
public @interface ResetPasswordMatch {

    String message() default "Mật khẩu xác nhận không khớp";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}