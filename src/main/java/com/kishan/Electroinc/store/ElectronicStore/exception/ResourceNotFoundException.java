package com.kishan.Electroinc.store.ElectronicStore.exception;

import lombok.Builder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Builder
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException()
    {
        super("Resource Not Found");
    }
    public ResourceNotFoundException(String message)
    {
        super(message);
    }

}
