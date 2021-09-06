package com.neivor.prueba.roxxy.enums;

public enum ServiceType {
    JACUSII ("1", "Jacussi", "Jacussi de 4 personas comunal");

    String serviceTypeId;
    String serviceTypeName;
    String serviceTypeDetail;

    ServiceType(String serviceTypeId, String serviceTypeName, String serviceTypeDetail) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
        this.serviceTypeDetail = serviceTypeDetail;
    }

    
}
