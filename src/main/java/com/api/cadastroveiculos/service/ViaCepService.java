package com.api.cadastroveiculos.service;

import com.api.cadastroveiculos.dto.ViaCepDto;
import com.api.cadastroveiculos.util.ViaCepUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    @Autowired
    private ViaCepUtil viaCepUtil;

    public ResponseEntity<ViaCepDto> getData(String cep) {
        return ResponseEntity.ok(viaCepUtil.getData(cep));
    }

}
