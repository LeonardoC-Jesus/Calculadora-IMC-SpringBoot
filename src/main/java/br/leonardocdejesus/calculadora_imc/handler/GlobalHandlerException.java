package br.leonardocdejesus.calculadora_imc.handler;

import br.leonardocdejesus.calculadora_imc.exception.InvalidFormatException;
import br.leonardocdejesus.calculadora_imc.exception.LessThanZeroException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e, Model model) {
        model.addAttribute("erro", e.getMessage());
        return "formulario";
    }

    @ExceptionHandler(LessThanZeroException.class)
    public String lessThanZeroHandlerException(LessThanZeroException e, Model model) {
        model.addAttribute("erro", e.getMessage());
        return "formulario";
    }

    @ExceptionHandler(InvalidFormatException.class)
    public String invalidFormatHandlerException(InvalidFormatException e, Model model) {
        model.addAttribute("erro", e.getMessage());
        return "formulario";
    }
}
