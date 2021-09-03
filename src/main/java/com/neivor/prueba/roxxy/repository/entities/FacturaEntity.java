package com.neivor.prueba.roxxy.repository.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "FACTURA")
public class FacturaEntity {
    private int idFactura;
    private int valorFactura;
    private int status;
    private Timestamp fechaRegistro;
    private String docPagador;

    @Id
    @Column(name = "ID_FACTURA")
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    @Basic
    @Column(name = "VALOR_FACTURA")
    public int getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(int valorFactura) {
        this.valorFactura = valorFactura;
    }

    @Basic
    @Column(name = "STATUS")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        FacturaEntity that = (FacturaEntity) o;
        return idFactura == that.idFactura && valorFactura == that.valorFactura && status == that.status && Objects.equals(fechaRegistro, that.fechaRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFactura, valorFactura, status, fechaRegistro);
    }

    @Basic
    @Column(name = "DOC_PAGADOR")
    public String getDocPagador() {
        return docPagador;
    }

    public void setDocPagador(String docPagador) {
        this.docPagador = docPagador;
    }
}
