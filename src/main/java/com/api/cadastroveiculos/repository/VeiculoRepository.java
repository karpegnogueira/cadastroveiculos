package com.api.cadastroveiculos.repository;


import com.api.cadastroveiculos.model.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {

    Optional<VeiculoModel> findByPlaca(String placa);

}
