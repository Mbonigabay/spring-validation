package dev.mbonigabay.validationdoc.util.validator;

import dev.mbonigabay.validationdoc.model.request.RegistrationRequest;
import dev.mbonigabay.validationdoc.util.constraint.PasswordMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, RegistrationRequest>{

    @Override
    public boolean isValid(RegistrationRequest value, ConstraintValidatorContext arg1) {
        return value.getPassword().equals(value.getConfirmation());
    }

    
}
