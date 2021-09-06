package com.neivor.prueba.roxxy.enums;

public enum InvoiceStatus {
    PENDING(1),
    PAY_AND_PENDING_REVIEW(2),
    REVERSE_PAY(4);

    private final int invoiceStatus;

    InvoiceStatus(int invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public int getInvoiceStatusCode() {
        return invoiceStatus;
    }
}
