package com.neivor.prueba.roxxy.repository.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DETALLE_FACTURA")
public class DetalleFacturaEntity {
    private int idDetalle;
    private String observaciones;
    private int numeroFactura;
    private int tipoServicio;

    @Id
    @Column(name = "ID_DETALLE")
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    @Basic
    @Column(name = "OBSERVACIONES")
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleFacturaEntity that = (DetalleFacturaEntity) o;
        return idDetalle == that.idDetalle && Objects.equals(observaciones, that.observaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDetalle, observaciones);
    }

    @Basic
    @Column(name = "NUMERO_FACTURA")
    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    @Basic
    @Column(name = "TIPO_SERVICIO")
    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}
