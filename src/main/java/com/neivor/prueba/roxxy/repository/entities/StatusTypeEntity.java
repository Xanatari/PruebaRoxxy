package com.neivor.prueba.roxxy.repository.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "STATUS_TYPE", schema = "TestRoxxy")
public class StatusTypeEntity {
    private int id;
    private String name;
    private String detail;
    private Timestamp fechaRegistro;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DETAIL")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "FECHA_REGISTRO")
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusTypeEntity that = (StatusTypeEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(detail, that.detail) && Objects.equals(fechaRegistro, that.fechaRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, detail, fechaRegistro);
    }
}
