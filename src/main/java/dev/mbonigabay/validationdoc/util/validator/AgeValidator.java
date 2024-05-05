package dev.mbonigabay.validationdoc.util.validator;

import java.time.LocalDate;

import dev.mbonigabay.validationdoc.util.constraint.Age;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, LocalDate>{
    private String min;

    @Override
    public void initialize(Age age) {
        System.out.println("age::"+age);
        this.min = age.min();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        System.out.println("min::"+min);
        return value.plusYears(Long.valueOf(min)).isBefore(LocalDate.now());
    }

}
