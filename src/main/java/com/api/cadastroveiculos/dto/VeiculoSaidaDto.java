package com.api.cadastroveiculos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoSaidaDto {

    private String placa;
    private Integer ano;
    private Double precoFipe;
    private Double precoDoAnuncio;
    private String nomeModelo;
    private String nomeMarca;
    private LocalDate dataCriacao;

}
