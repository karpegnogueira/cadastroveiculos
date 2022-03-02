package com.api.cadastroveiculos.controller;

import com.api.cadastroveiculos.dto.VeiculoEntradaDto;
import com.api.cadastroveiculos.dto.VeiculoSaidaDto;
import com.api.cadastroveiculos.model.VeiculoModel;
import com.api.cadastroveiculos.service.VeiculoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;


class VeiculoControllerTest {

    private VeiculoController feature;
    private VeiculoService service;

    @BeforeEach
    void setUp() {
        service = Mockito.mock(VeiculoService.class);
        feature = new VeiculoController(service);
    }

    @Test
    void saveVeiculoOk() {
        Mockito.when(service.save(Mockito.any())).thenReturn(new VeiculoSaidaDto());
        Assertions.assertNotNull(feature.saveVeiculo(new VeiculoEntradaDto()));
    }

    @Test
    void saveVeiculoErro() {
        Mockito.when(service.save(Mockito.any())).thenThrow(new RuntimeException());
        Assertions.assertThrows(Exception.class, () -> feature.saveVeiculo(new VeiculoEntradaDto()));
    }

    @Test
    void buscarPorPlacaOk() {
        Mockito.when(service.buscaPorPlaca(Mockito.anyString())).thenReturn(new VeiculoSaidaDto());
        Assertions.assertNotNull(feature.buscarPorPlaca(""));
    }

    @Test
    void buscarPorPlacaErro() {
        Mockito.when(service.buscaPorPlaca(Mockito.anyString())).thenThrow(new RuntimeException());
        Assertions.assertThrows(Exception.class, () -> feature.buscarPorPlaca(""));
    }

    @Test
    void buscaTodosPaginadoOK() {
        Mockito.when(service.findAll(Mockito.any())).thenReturn(new PageImpl<VeiculoModel>(List.of()));
        Assertions.assertNotNull(feature.buscaTodosPaginado(new PageRequest(0, 10, Sort.unsorted()) {}));
    }

    @Test
    void buscaTodosPaginadoErro() {
        Mockito.when(service.findAll(Mockito.any())).thenThrow(new RuntimeException());
        Assertions.assertThrows(Exception.class, () -> feature.buscaTodosPaginado(new PageRequest(0, 10, Sort.unsorted()) {}));
    }

}
