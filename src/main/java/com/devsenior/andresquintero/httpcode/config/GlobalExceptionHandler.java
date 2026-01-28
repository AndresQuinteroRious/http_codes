package com.devsenior.andresquintero.httpcode.config;

import java.time.LocalDateTime;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsenior.andresquintero.httpcode.dto.ApiErrorResponse;
import com.devsenior.andresquintero.httpcode.exepcion.AlreadyExistEcxeption;
import com.devsenior.andresquintero.httpcode.exepcion.EmailAlreadyExistEcxeption;
import com.devsenior.andresquintero.httpcode.exepcion.MissingValuesException;
import com.devsenior.andresquintero.httpcode.exepcion.UserNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice

public class GlobalExceptionHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ApiErrorResponse<List<String>>> handleMethodValidationException(
                        MethodArgumentNotValidException exception,
                        HttpServletRequest request) {

                var messages = exception.getFieldErrors().stream()
                                .map(e -> e.getDefaultMessage())
                                .toList();

                return ResponseEntity.badRequest()
                                .body(new ApiErrorResponse<>(
                                                LocalDateTime.now(),
                                                HttpStatus.BAD_REQUEST,
                                                messages,
                                                request.getRequestURI()));
        }

        @ExceptionHandler(AlreadyExistEcxeption.class)

        public ResponseEntity<ApiErrorResponse<String>> handleAlreadyExistException(
                        AlreadyExistEcxeption exception,
                        HttpServletRequest request) {

                return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body(new ApiErrorResponse<>(
                                                LocalDateTime.now(),
                                                HttpStatus.CONFLICT,
                                                exception.getMessage(),
                                                request.getRequestURI()));
        }

        @ExceptionHandler(MissingValuesException.class)

        public ResponseEntity<ApiErrorResponse<String>> handleMissingValuesException(
                        MissingValuesException exception,
                        HttpServletRequest request) {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(new ApiErrorResponse<>(
                                                LocalDateTime.now(),
                                                HttpStatus.BAD_REQUEST,
                                                exception.getMessage(),
                                                request.getRequestURI()));
        }

        @ExceptionHandler(UserNotFoundException.class)

        public ResponseEntity<ApiErrorResponse<String>> handleUserNotFoundException(
                        UserNotFoundException exception,
                        HttpServletRequest request) {

                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(new ApiErrorResponse<>(
                                                LocalDateTime.now(),
                                                HttpStatus.NOT_FOUND,
                                                exception.getMessage(),
                                                request.getRequestURI()));
        }

        @ExceptionHandler(EmailAlreadyExistEcxeption.class)

        public ResponseEntity<ApiErrorResponse<String>> handleEmailAlreadyExistException(
                        EmailAlreadyExistEcxeption exception, HttpServletRequest request) {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(new ApiErrorResponse<>(
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
        // @ExceptionHandler(Exception.class)

        public ResponseEntity<ApiErrorResponse<String>> handleException(
                        Exception exception, HttpServletRequest request) {
                return ResponseEntity.internalServerError()
                                .body(new ApiErrorResponse<>(
                                                LocalDateTime.now(),
                                                HttpStatus.BAD_REQUEST,
                                                exception.getMessage(),
                                                request.getRequestURI()));
        }

}
