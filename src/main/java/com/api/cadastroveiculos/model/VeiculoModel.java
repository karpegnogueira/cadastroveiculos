package com.api.cadastroveiculos.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VEICULO_TB")
public class VeiculoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false, name = "preco_fipe")
    private Double precoFipe;

    @Column(nullable = false, name = "preco_anuncio")
    private Double precoDoAnuncio;

    @CreationTimestamp
    @Column(nullable = false, name = "data_cadastro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private ModeloModel modeloModel;

}
