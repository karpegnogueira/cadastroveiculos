package com.api.cadastroveiculos.service;


import com.api.cadastroveiculos.dto.VeiculoEntradaDto;
import com.api.cadastroveiculos.dto.VeiculoSaidaDto;
import com.api.cadastroveiculos.model.VeiculoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

public interface VeiculoService {

    Page<VeiculoModel> findAll(Pageable pageable);
    VeiculoSaidaDto buscaPorPlaca(String placa);
    VeiculoSaidaDto save(@Valid VeiculoEntradaDto veiculo);


}
