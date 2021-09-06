package com.neivor.prueba.roxxy.enums;

public enum ServiceType {
    JACUSII(1, "Jacussi", "Jacussi de 4 personas comunal");

    int serviceTypeId;
    String serviceTypeName;
    String serviceTypeDetail;

    ServiceType(int serviceTypeId, String serviceTypeName, String serviceTypeDetail) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
        this.serviceTypeDetail = serviceTypeDetail;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public String getServiceTypeDetail() {
        return serviceTypeDetail;
    }
}
