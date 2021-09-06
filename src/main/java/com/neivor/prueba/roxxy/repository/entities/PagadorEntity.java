package com.neivor.prueba.roxxy.repository.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PAGADOR", schema = "TestRoxxy")
public class PagadorEntity {
    private String documentoPagador;
    private String nombrePagador;
    private String numeroCasa;
    private int valorFactura;
    private Timestamp fechaRegistro;
    private Integer idCondominio;

    @Id
    @Column(name = "DOCUMENTO_PAGADOR")
    public String getDocumentoPagador() {
        return documentoPagador;
    }

    public void setDocumentoPagador(String documentoPagador) {
        this.documentoPagador = documentoPagador;
    }

    @Basic
    @Column(name = "NOMBRE_PAGADOR")
    public String getNombrePagador() {
        return nombrePagador;
    }

    public void setNombrePagador(String nombrePagador) {
        this.nombrePagador = nombrePagador;
    }

    @Basic
    @Column(name = "NUMERO_CASA")
    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
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
        PagadorEntity that = (PagadorEntity) o;
        return valorFactura == that.valorFactura && Objects.equals(documentoPagador, that.documentoPagador) && Objects.equals(nombrePagador, that.nombrePagador) && Objects.equals(numeroCasa, that.numeroCasa) && Objects.equals(fechaRegistro, that.fechaRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentoPagador, nombrePagador, numeroCasa, valorFactura, fechaRegistro);
    }

    @Basic
    @Column(name = "ID_CONDOMINIO")
    public Integer getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(Integer idCondominio) {
        this.idCondominio = idCondominio;
    }
}
