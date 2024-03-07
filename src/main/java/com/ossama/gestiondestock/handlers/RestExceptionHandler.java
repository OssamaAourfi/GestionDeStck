package com.ossama.gestiondestock.handlers;

import com.ossama.gestiondestock.exception.EntityNotFoundException;
import com.ossama.gestiondestock.exception.ErrorCodes;
import com.ossama.gestiondestock.exception.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorsDto> handleException(EntityNotFoundException exception, WebRequest webRequest) {

        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final ErrorsDto errorDto = ErrorsDto.builder()
                .code(exception.getErrorCode())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorDto, notFound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorsDto> handleException(InvalidEntityException exception, WebRequest webRequest) {

        final HttpStatus notFound = HttpStatus.BAD_REQUEST;
        final ErrorsDto errorDto = ErrorsDto.builder()
                .code(exception.getErrorCode())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorDto, notFound);
    }

//    @ExceptionHandler(InvalidEntityException.class)
//    public ResponseEntity<ErrorsDto> handleException(InvalidEntityException exception, WebRequest webRequest) {
//        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
//
//        final ErrorsDto errorDto = ErrorsDto.builder()
//                .code(exception.getErrorCode())
//                .httpCode(badRequest.value())
//                .message(exception.getMessage())
//                .errors(exception.getErrors())
//                .build();
//
//        return new ResponseEntity<>(errorDto, badRequest);
//    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorsDto> handleException(BadCredentialsException exception, WebRequest webRequest) {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        final ErrorsDto errorDto = ErrorsDto.builder()
                .code(ErrorCodes.BAD_CREDENTIALS)
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(Collections.singletonList("Login et / ou mot de passe incorrecte"))
                .build();

        return new ResponseEntity<>(errorDto, badRequest);
    }

}