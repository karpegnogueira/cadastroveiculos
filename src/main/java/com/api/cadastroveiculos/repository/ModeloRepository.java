package com.api.cadastroveiculos.repository;


import com.api.cadastroveiculos.model.ModeloModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModeloRepository extends JpaRepository<ModeloModel, UUID> {

}
