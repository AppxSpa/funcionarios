package com.funcionarios.funcionarios.mappers;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class ErrorValidationMapper {

    public Map<String, String> mapValidationErrors(BindingResult result) {

        Map<String, String> errors = new java.util.HashMap<>();

        result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

}
