package com.api.cadastroveiculos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoEntradaDto {

    @NotBlank
    private String placa;

    private UUID idMarca;

    private UUID idModelo;

    @NotNull
    private Double precoAnuncio;

    @NotNull
    private Integer ano;

}
