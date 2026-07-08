package br.leonardocdejesus.calculadora_imc.controller;

import br.leonardocdejesus.calculadora_imc.dto.ImcRegistroDto;
import br.leonardocdejesus.calculadora_imc.model.ImcRegistro;
import br.leonardocdejesus.calculadora_imc.service.ImcRegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/imc")
public class ImcRegistroController {

    private final ImcRegistroService imcRegistroService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ImcRegistro> getImcRegistro() {
        return imcRegistroService.retornarHistoricoDeImc();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public double postImcRegistro(@RequestBody ImcRegistroDto imcRegistroDto) {
        return imcRegistroService.registrarImc(imcRegistroDto);
    }
}
