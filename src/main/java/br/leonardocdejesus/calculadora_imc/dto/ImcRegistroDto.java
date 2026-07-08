package br.leonardocdejesus.calculadora_imc.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImcRegistroDto {

    private double peso;
    private double altura;

}
