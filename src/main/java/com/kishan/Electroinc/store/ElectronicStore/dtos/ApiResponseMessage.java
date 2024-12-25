package com.kishan.Electroinc.store.ElectronicStore.dtos;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ApiResponseMessage {


    private  String message;
    private  boolean success;

    private HttpStatus status;

}
