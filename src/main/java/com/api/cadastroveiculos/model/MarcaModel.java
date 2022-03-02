package com.api.cadastroveiculos.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MARCA_TB")
@Entity
public class MarcaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "name")
    private String nomeMarca;

    @Column(name = "fipe_id")
    private Long fipeId;

    @OneToMany
    private List<ModeloModel> modeloModel;

}
