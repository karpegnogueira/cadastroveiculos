package com.api.cadastroveiculos.service.serviceimpl;


import com.api.cadastroveiculos.dto.VeiculoEntradaDto;
import com.api.cadastroveiculos.dto.VeiculoSaidaDto;
import com.api.cadastroveiculos.model.MarcaModel;
import com.api.cadastroveiculos.model.ModeloModel;
import com.api.cadastroveiculos.model.VeiculoModel;
import com.api.cadastroveiculos.repository.ModeloRepository;
import com.api.cadastroveiculos.repository.VeiculoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class VeiculoServiceImplTest {

    private VeiculoServiceImpl feature;

    private VeiculoRepository veiculoRepository;

    private ModeloRepository modeloRepository;


    @BeforeEach
    void setUp() {
        veiculoRepository = Mockito.mock(VeiculoRepository.class);
        modeloRepository = Mockito.mock(ModeloRepository.class);
        feature = new VeiculoServiceImpl(veiculoRepository, modeloRepository);
    }

    @Test
    void findAll() {
        Mockito.when(veiculoRepository.findAll(Mockito.any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of()));
        Assertions.assertNotNull(feature.findAll(new PageRequest(0, 10, Sort.unsorted()) {
        }));
    }

    @Test
    void buscaPorPlaca() {
        Mockito.when(veiculoRepository.findByPlaca(Mockito.anyString())).thenReturn(Optional.of(getModel()));
        Assertions.assertNotNull(feature.buscaPorPlaca(""));
    }

    @Test
    void save() {
        Mockito.when(modeloRepository.findById(Mockito.any())).thenReturn(Optional.of(getModelo()));
        Mockito.when(veiculoRepository.save(Mockito.any())).thenReturn(getModel());
        Assertions.assertNotNull(feature.save(getEntrada()));
    }

    private VeiculoEntradaDto getEntrada() {
        VeiculoEntradaDto entrada = new VeiculoEntradaDto();
        entrada.setIdModelo(UUID.fromString("5bc16064-d3ee-4aed-a264-a914233d0c4f"));
        return entrada;
    }

    private VeiculoModel getModel() {
        VeiculoModel model = new VeiculoModel();
        model.setAno(2000);
        model.setModeloModel(getModelo());
        model.setPlaca("AAA-XXXX");
        model.setPrecoDoAnuncio(25.1);
        model.setPrecoFipe(new Random().nextDouble() * 1000);

        return model;
    }

    private ModeloModel getModelo() {

        ModeloModel modelo = new ModeloModel();
        modelo.setNomeModelo("Range Rover");
        modelo.setMarcaModel(getMarca());
        return modelo;
    }


    private MarcaModel getMarca() {

        MarcaModel modelo = new MarcaModel();
        modelo.setNomeMarca("Evoque");
        return modelo;
    }

}
