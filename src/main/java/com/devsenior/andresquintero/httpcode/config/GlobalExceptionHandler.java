package com.devsenior.andresquintero.httpcode.config;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsenior.andresquintero.httpcode.dto.ApiErrorResponse;
import com.devsenior.andresquintero.httpcode.exepcion.EmailAlreadyExistEcxeption;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistEcxeption.class)

    public ResponseEntity<ApiErrorResponse> handleEmailAlreadyExistException(
            EmailAlreadyExistEcxeption exception, HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST,
                        "el correo electronico ya existe en la lista de usuarios",
                        request.getRequestURI()));
    }

    /*
     * var apiErrorResponse = new ApiErrorResponse(
     * LocalDateTime.now(),
     * HttpStatus.BAD_REQUEST,
     * exception.getMessage(),
     * "/api/global"
     * );
     * return ResponseEntity.status(HttpStatus.BAD_REQUEST)
     * .body("El correo electrónico ya existe");
     * }
     */
@ExceptionHandler(Exception.class)

    public ResponseEntity<ApiErrorResponse> handleException(
        Exception exception, HttpServletRequest request) {
        return ResponseEntity.internalServerError()
        .body(new ApiErrorResponse(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST,
            exception.getMessage(),
            request.getRequestURI()));
    }

}
