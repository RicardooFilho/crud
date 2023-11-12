package br.edu.unicesumar.crud.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ES_CARRO")
public class Carro {

    @Id
    private Long id;

    @Column
    private Double peso;

    @Column
    private Integer ano;
}


