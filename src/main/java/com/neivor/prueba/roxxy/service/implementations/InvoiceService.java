package com.neivor.prueba.roxxy.service.implementations;

import com.neivor.prueba.roxxy.dtos.request.InvoiceGenericRequest;
import com.neivor.prueba.roxxy.enums.InvoiceStatus;
import com.neivor.prueba.roxxy.repository.contracts.IFacturaEntity;
import com.neivor.prueba.roxxy.repository.entities.FacturaEntity;
import com.neivor.prueba.roxxy.service.contracts.IInvoiceService;
import lombok.var;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class InvoiceService implements IInvoiceService {
    private static final Logger LOGGER = LogManager.getLogger(InvoiceService.class);

    IFacturaEntity iFacturaEntity;

    @Autowired
    public InvoiceService(IFacturaEntity iFacturaEntity) {
        this.iFacturaEntity = iFacturaEntity;
    }

    @Override
    public void registerRecord(InvoiceGenericRequest invoiceGenericRequest) {

        LOGGER.debug("Start register recor new invoice for this national id {}", invoiceGenericRequest.getNationalId());
        var facturaEntity = new FacturaEntity();

        facturaEntity.setValorFactura(invoiceGenericRequest.getInvoiceAmmount());
        facturaEntity.setDocPagador(invoiceGenericRequest.getNationalId());
        facturaEntity.setStatus(Optional.of(invoiceGenericRequest.getStatus()).orElse(InvoiceStatus.PENDING.getInvoiceStatusCode()));
        facturaEntity.setFechaRegistro(new Timestamp(new Date().getTime()));

        iFacturaEntity.save(facturaEntity);


    }
}
