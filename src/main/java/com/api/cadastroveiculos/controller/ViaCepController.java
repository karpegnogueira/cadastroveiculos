package com.api.cadastroveiculos.controller;

import com.api.cadastroveiculos.dto.ViaCepDto;
import com.api.cadastroveiculos.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViaCepController {

    @Autowired
    private ViaCepService service;

    @GetMapping("/{cep}")
    public ResponseEntity<ViaCepDto> getData(@PathVariable String cep){
        return service.getData(cep);
    }

}
