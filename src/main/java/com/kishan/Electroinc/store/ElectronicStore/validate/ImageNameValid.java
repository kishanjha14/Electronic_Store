package com.kishan.Electroinc.store.ElectronicStore.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ImageNameValidator.class)
public  @interface  ImageNameValid{

    //error Message
    String message() default "{Invalid Image Name Provided}";
    //  represent group constraints
    Class<?>[] groups() default { };
    // additional Information about annotation
    Class<? extends Payload>[] payload() default { };
}
