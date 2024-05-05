package dev.mbonigabay.validationdoc.util.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dev.mbonigabay.validationdoc.util.validator.AgeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {
    String min();
    String message() default "Applicant must be 18";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
