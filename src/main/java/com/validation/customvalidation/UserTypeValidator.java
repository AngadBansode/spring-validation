package com.validation.customvalidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class UserTypeValidator implements ConstraintValidator<ValidateUserType, String> {
    @Override
    public boolean isValid(String type, ConstraintValidatorContext context) {
        List<String> list = List.of("Root", "Admin");
        return list.stream().anyMatch(e -> e.equalsIgnoreCase(type));

    }
}
