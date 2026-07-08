package br.leonardocdejesus.calculadora_imc.exception;

public class LessThanZeroException extends RuntimeException {
    public LessThanZeroException(String message) {
        super(message);
    }
}
