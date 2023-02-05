package com.hoaxify.ws.user;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {UniqeUsernameValidator.class}
)
public @interface UniqeUsername {
    String message() default "Username must be uniqe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
