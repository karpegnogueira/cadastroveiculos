package com.api.cadastroveiculos.service.serviceimpl;


import com.api.cadastroveiculos.dto.VeiculoEntradaDto;
import com.api.cadastroveiculos.dto.VeiculoSaidaDto;
import com.api.cadastroveiculos.model.VeiculoModel;
import com.api.cadastroveiculos.repository.ModeloRepository;
import com.api.cadastroveiculos.repository.VeiculoRepository;
import com.api.cadastroveiculos.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    private final ModeloRepository modeloRepository;

    @Override
    public Page<VeiculoModel> findAll(Pageable pageable) {
        return veiculoRepository.findAll(pageable);
    }


    @Override
    public VeiculoSaidaDto save(@Valid VeiculoEntradaDto veiculo) {

        VeiculoModel model = fillModel(veiculo);

        VeiculoModel saved = veiculoRepository.save(model);

        VeiculoSaidaDto saida = fillSaida(saved);

        return saida;
    }

    private VeiculoSaidaDto fillSaida(VeiculoModel saved) {
        VeiculoSaidaDto saida = new VeiculoSaidaDto();
        saida.setAno(saved.getAno());
        saida.setNomeMarca(saved.getModeloModel().getMarcaModel().getNomeMarca());
        saida.setNomeModelo(saved.getModeloModel().getNomeModelo());
        saida.setPlaca(saved.getPlaca());
        saida.setPrecoDoAnuncio(saved.getPrecoDoAnuncio());
        saida.setPrecoFipe(saved.getPrecoFipe());
        saida.setDataCriacao(saved.getDataCadastro());
        return saida;
    }

    private VeiculoModel fillModel(VeiculoEntradaDto veiculo) {
        VeiculoModel model = new VeiculoModel();
        model.setAno(veiculo.getAno());
        model.setModeloModel(modeloRepository.findById(veiculo.getIdModelo()).orElseThrow());
        model.setPlaca(veiculo.getPlaca());
        model.setPrecoDoAnuncio(veiculo.getPrecoAnuncio());
        model.setPrecoFipe(new Random().nextDouble() * 1000);

        return model;
    }

    @Override
    public VeiculoSaidaDto buscaPorPlaca(String placa) {
        return fillSaida(veiculoRepository.findByPlaca(placa).orElseThrow());
    }

}
