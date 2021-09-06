package com.neivor.prueba.roxxy.enums;

public enum InvoiceStatus {
    PENDING(1);

    private final int invoiceStatus;

    InvoiceStatus(int invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
    public int getInvoiceStatusCode(){ return  invoiceStatus;}
}
