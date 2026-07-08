package br.leonardocdejesus.calculadora_imc.service;

import br.leonardocdejesus.calculadora_imc.exception.InvalidFormatException;
import br.leonardocdejesus.calculadora_imc.exception.LessThanZeroException;
import br.leonardocdejesus.calculadora_imc.model.ImcRegistro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImcRegistroService {

    List<ImcRegistro> historicoDeRegistros = new ArrayList<>();

    public double registrarImc(ImcRegistro imcRegistro) {
        if (imcRegistro.getPeso() < 0) throw new LessThanZeroException("Peso informado está abaixo de zero!");
        if (imcRegistro.getAltura() < 0) throw new LessThanZeroException("Altura informada está abaixo de zero!");
        validarFormatoAltura(imcRegistro.getAltura());

        imcRegistro.setImc(imcRegistro.getPeso() * (imcRegistro.getAltura() * imcRegistro.getAltura()));
        imcRegistro.setClassificacao(classificarImc(imcRegistro.getImc()));

        historicoDeRegistros.add(imcRegistro);
        return imcRegistro.getImc();
    }

    public List<ImcRegistro> retornarHistoricoDeImc() {
        return historicoDeRegistros;
    }

    private void validarFormatoAltura(double altura) {
        String alturaString = String.valueOf(altura);
        if (!alturaString.contains(".")) throw new InvalidFormatException("A altura não está no formato em metros!");
    }

    private String classificarImc(double calculoImc) {
        if (calculoImc < 18.5) return "Abaixo do peso";
        if (calculoImc <= 24.9) return "Normal";
        if (calculoImc <= 29.9) return "Sobrepeso";
        return "Obesidade";
    }

}
