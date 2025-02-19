package com.neivor.prueba.roxxy.repository.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "transacciones")
@Getter
@Setter
public class TransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Version
    private Integer version;

    // Getters y setters...
}