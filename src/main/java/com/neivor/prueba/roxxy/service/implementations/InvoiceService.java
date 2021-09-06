package com.neivor.prueba.roxxy.service.implementations;

import com.neivor.prueba.roxxy.dtos.request.InvoiceGenericRequest;
import com.neivor.prueba.roxxy.dtos.responses.PayerGenericResponse;
import com.neivor.prueba.roxxy.enums.InvoiceStatus;
import com.neivor.prueba.roxxy.exceptions.InvocieNotFoundException;
import com.neivor.prueba.roxxy.repository.contracts.IDetalleFacturaEntity;
import com.neivor.prueba.roxxy.repository.contracts.IFacturaEntity;
import com.neivor.prueba.roxxy.repository.entities.DetalleFacturaEntity;
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
    IDetalleFacturaEntity iDetalleFacturaEntity;

    @Autowired
    public InvoiceService(IFacturaEntity iFacturaEntity,
                          IDetalleFacturaEntity iDetalleFacturaEntity) {
        this.iFacturaEntity = iFacturaEntity;
        this.iDetalleFacturaEntity = iDetalleFacturaEntity;
    }

    @Override
    public int registerRecord(InvoiceGenericRequest invoiceGenericRequest) {

        LOGGER.debug("Start register recor new invoice for this national id {}", invoiceGenericRequest.getNationalId());
        var facturaEntity = new FacturaEntity();

       if (!invoiceGenericRequest.getDetailInvoiceGenericList().isEmpty()){
           LOGGER.debug("Start register record for Invocie by nationalId {} have detail " , invoiceGenericRequest.getNationalId());
           facturaEntity.setValorFactura(invoiceGenericRequest.getInvoiceAmmount());
           facturaEntity.setDocPagador(invoiceGenericRequest.getNationalId());
           facturaEntity.setStatus(Optional.of(invoiceGenericRequest.getStatus()).orElse(InvoiceStatus.PENDING.getInvoiceStatusCode()));
           facturaEntity.setFechaRegistro(new Timestamp(new Date().getTime()));

           facturaEntity = iFacturaEntity.save(facturaEntity);

           FacturaEntity finalFacturaEntity = facturaEntity;
           invoiceGenericRequest.getDetailInvoiceGenericList().forEach(detail -> {
               var detalleFacturaEntity  = new DetalleFacturaEntity();
               detalleFacturaEntity.setNumeroFactura(finalFacturaEntity.getIdFactura());
               detalleFacturaEntity.setObservaciones(detail.getObservations());
               detalleFacturaEntity.setTipoServicio(detail.getServiceType());
               iDetalleFacturaEntity.save(detalleFacturaEntity);
           });
       } else {
           LOGGER.debug("Start register record for Invocie by nationalId {} dont have detail " , invoiceGenericRequest.getNationalId());
           facturaEntity.setValorFactura(invoiceGenericRequest.getInvoiceAmmount());
           facturaEntity.setDocPagador(invoiceGenericRequest.getNationalId());
           facturaEntity.setStatus(Optional.of(invoiceGenericRequest.getStatus()).orElse(InvoiceStatus.PENDING.getInvoiceStatusCode()));
           facturaEntity.setFechaRegistro(new Timestamp(new Date().getTime()));

           facturaEntity = iFacturaEntity.save(facturaEntity);
       }



        return facturaEntity.getIdFactura();
    }

    @Override
    public void updateInvoice(InvoiceGenericRequest invoiceGenericRequest) throws InvocieNotFoundException{
        try{
            LOGGER.info("Strat get Payer detail by InvoiceId");
            var iFactura = iFacturaEntity.findById(invoiceGenericRequest.getInvoiceId());
            if(!iFactura.isPresent()){
                LOGGER.error("Error to optain detail for this Invoice id {}", invoiceGenericRequest.getInvoiceId());
                throw new InvocieNotFoundException("Invoice Id not found");
            }
            var f = iFactura.get();

            f.setStatus(InvoiceStatus.PAY_AND_PENDING_REVIEW.getInvoiceStatusCode());
            iFacturaEntity.save(f);

        }catch (InvocieNotFoundException invocieNotFoundException){
            LOGGER.error("Error to register the Payer info ");
            throw invocieNotFoundException;
        }
        catch (Exception e){
            LOGGER.error("Generic error to register payer info");
            throw e;
        }
    }

    @Override
    public void reverseInvoice(InvoiceGenericRequest invoiceGenericRequest) throws InvocieNotFoundException {
        try{
            LOGGER.info("Strat get Payer detail by InvoiceId");
            var iFactura = iFacturaEntity.findById(invoiceGenericRequest.getInvoiceId());
            if(!iFactura.isPresent()){
                LOGGER.error("Error to optain detail for this Invoice id {}", invoiceGenericRequest.getInvoiceId());
                throw new InvocieNotFoundException("Invoice Id not found");
            }
            var f = iFactura.get();

            f.setStatus(InvoiceStatus.REVERSE_PAY.getInvoiceStatusCode());
            iFacturaEntity.save(f);

        }catch (InvocieNotFoundException invocieNotFoundException){
            LOGGER.error("Error to register the Payer info ");
            throw invocieNotFoundException;
        }
        catch (Exception e){
            LOGGER.error("Generic error to register payer info");
            throw e;
        }
    }
}
