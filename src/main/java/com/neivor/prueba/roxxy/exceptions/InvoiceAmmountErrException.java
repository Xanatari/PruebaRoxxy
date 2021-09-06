package com.neivor.prueba.roxxy.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceAmmountErrException extends  Exception{
    private final int ammount;

    public InvoiceAmmountErrException( int ammount){
        super(String.format("Error to register this Payer wrong amount the suggested amount is [%s] ", ammount));
        this.ammount = ammount;
    }
}
