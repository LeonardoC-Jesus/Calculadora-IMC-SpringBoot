package br.leonardocdejesus.calculadora_imc.controller;

import br.leonardocdejesus.calculadora_imc.dto.ImcRegistroDto;
import br.leonardocdejesus.calculadora_imc.model.ImcRegistro;
import br.leonardocdejesus.calculadora_imc.service.ImcRegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/imc")
public class ImcRegistroController {

    private final ImcRegistroService imcRegistroService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getFormulario() {
        return "formulario";
    }

    @GetMapping("/historico")
    @ResponseStatus(HttpStatus.OK)
    public String getImcRegistro(Model model) {
        List<ImcRegistro> historicoDeImc = imcRegistroService.retornarHistoricoDeImc();
        model.addAttribute("historico_de_registros", historicoDeImc);
        return "historico";
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public String postImcRegistro(ImcRegistroDto imcRegistroDto, Model model) {
        double imc_calculado = imcRegistroService.registrarImc(imcRegistroDto);
        model.addAttribute("imc_calculado", imc_calculado);

        return "formulario";
    }
}
