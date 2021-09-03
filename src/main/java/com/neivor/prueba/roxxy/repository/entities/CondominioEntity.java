package com.neivor.prueba.roxxy.repository.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CONDOMINIO")
public class CondominioEntity {
    private int idCondominio;
    private String nombreCondominio;
    private String dirreccionCondominio;

    @Id
    @Column(name = "ID_CONDOMINIO")
    public int getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(int idCondominio) {
        this.idCondominio = idCondominio;
    }

    @Basic
    @Column(name = "NOMBRE_CONDOMINIO")
    public String getNombreCondominio() {
        return nombreCondominio;
    }

    public void setNombreCondominio(String nombreCondominio) {
        this.nombreCondominio = nombreCondominio;
    }

    @Basic
    @Column(name = "DIRRECCION_CONDOMINIO")
    public String getDirreccionCondominio() {
        return dirreccionCondominio;
    }

    public void setDirreccionCondominio(String dirreccionCondominio) {
        this.dirreccionCondominio = dirreccionCondominio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CondominioEntity that = (CondominioEntity) o;
        return idCondominio == that.idCondominio && Objects.equals(nombreCondominio, that.nombreCondominio) && Objects.equals(dirreccionCondominio, that.dirreccionCondominio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCondominio, nombreCondominio, dirreccionCondominio);
    }
}
