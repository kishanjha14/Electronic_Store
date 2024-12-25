package com.kishan.Electroinc.store.ElectronicStore.validate;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ImageNameValidator implements ConstraintValidator<ImageNameValid,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.isBlank())
        {
            return  false;
        }
        else {
            return true;
        }

    }
}
