package dev.mbonigabay.validationdoc.util.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dev.mbonigabay.validationdoc.util.validator.PasswordMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = PasswordMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatch {
    String message() default "Password doesn't match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
