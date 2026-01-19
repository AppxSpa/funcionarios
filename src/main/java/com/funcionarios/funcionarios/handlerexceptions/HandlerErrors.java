package com.funcionarios.funcionarios.handlerexceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.funcionarios.funcionarios.exceptions.EscalafonException;
import com.funcionarios.funcionarios.exceptions.FuncionarioExceptions;
import com.funcionarios.funcionarios.exceptions.NotFoundEscalafonException;
import com.funcionarios.funcionarios.exceptions.NotFoundFuncionarioException;
import com.funcionarios.funcionarios.exceptions.NotFoundTipoContratoException;
import com.funcionarios.funcionarios.exceptions.TipoContratoException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerErrors {

    @ExceptionHandler(FuncionarioExceptions.class)
    public ResponseEntity<ErrorResponse> handlerFuncionario(FuncionarioExceptions e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse error = maptoErrorResponse(e, request, status);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(NotFoundFuncionarioException.class)
    public ResponseEntity<ErrorResponse> handlerFuncionarioNotFound(NotFoundFuncionarioException e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = maptoErrorResponse(e, request, status);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(EscalafonException.class)
    public ResponseEntity<ErrorResponse> handlerEscalafonNotFound(EscalafonException e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = maptoErrorResponse(e, request, status);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(TipoContratoException.class)
    public ResponseEntity<ErrorResponse> handlerTipoContratoNotFound(TipoContratoException e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = maptoErrorResponse(e, request, status);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(NotFoundTipoContratoException.class)
    public ResponseEntity<ErrorResponse> handlerTipoContratoNotFound(NotFoundTipoContratoException e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = maptoErrorResponse(e, request, status);
        return ResponseEntity.status(status).body(error);
    }

     @ExceptionHandler(NotFoundEscalafonException.class)
    public ResponseEntity<ErrorResponse> handlerEscalafonNotFound(NotFoundEscalafonException e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = maptoErrorResponse(e, request, status);
        return ResponseEntity.status(status).body(error);
    }

    private <T extends Exception> ErrorResponse maptoErrorResponse(T e, HttpServletRequest request, HttpStatus status) {

        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .mensaje(e.getMessage())
                .ruta(request.getRequestURI())
                .build();

    }

}
