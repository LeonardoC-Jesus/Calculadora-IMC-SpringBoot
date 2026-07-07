package br.leonardocdejesus.calculadora_imc.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImcRegistro {

    private double peso;
    private double altura;
    private double imc;
    private String classificacao;
}
