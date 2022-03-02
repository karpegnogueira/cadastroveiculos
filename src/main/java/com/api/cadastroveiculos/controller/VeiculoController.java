package com.api.cadastroveiculos.controller;


import com.api.cadastroveiculos.model.VeiculoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.cadastroveiculos.dto.VeiculoEntradaDto;
import com.api.cadastroveiculos.dto.VeiculoSaidaDto;
import com.api.cadastroveiculos.service.VeiculoService;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("veiculo")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoSaidaDto> saveVeiculo(@RequestBody @Valid VeiculoEntradaDto veiculo){
        return ResponseEntity.ok(veiculoService.save(veiculo));
    }

    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoSaidaDto> buscarPorPlaca(@PathVariable String placa){
        return ResponseEntity.ok(veiculoService.buscaPorPlaca(placa));
    }

    @GetMapping
    public Page<VeiculoModel> buscaTodosPaginado(@PageableDefault(page = 0, size = 10) Pageable pageable){
        return veiculoService.findAll(pageable);
    }

}
