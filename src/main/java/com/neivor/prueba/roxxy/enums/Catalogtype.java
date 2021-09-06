package com.neivor.prueba.roxxy.enums;

public enum Catalogtype {
    SERVICE_TYPE("SERVICE_TYPE"),
    STATUS_TYPE("STATUS_TYPE");

    String catalogType;

    Catalogtype(String catalogType) {
        this.catalogType = catalogType;
    }

    public String getCatalogType() {
        return catalogType;
    }
}
