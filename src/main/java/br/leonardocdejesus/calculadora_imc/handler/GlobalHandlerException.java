package br.leonardocdejesus.calculadora_imc.handler;

import br.leonardocdejesus.calculadora_imc.exception.ErrorResponse;
import br.leonardocdejesus.calculadora_imc.exception.InvalidFormatException;
import br.leonardocdejesus.calculadora_imc.exception.LessThanZeroException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerException(Exception e) {
        ErrorResponse response = ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(LessThanZeroException.class)
    public ResponseEntity<ErrorResponse> lessThanZeroHandlerException(LessThanZeroException e) {
        ErrorResponse response = ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ErrorResponse> invalidFormatHandlerException(InvalidFormatException e) {
        ErrorResponse response = ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
