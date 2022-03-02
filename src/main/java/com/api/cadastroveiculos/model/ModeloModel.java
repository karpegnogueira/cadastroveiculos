package com.api.cadastroveiculos.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MODELO_TB")
public class ModeloModel {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, name = "name")
    private String nomeModelo;

    @Column(name = "fipe_id")
    private Long fipeId;

    @OneToMany
    private List<VeiculoModel> veiculoModel;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private MarcaModel marcaModel;

}
