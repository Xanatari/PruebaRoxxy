package com.neivor.prueba.roxxy.service.implementations;

import com.neivor.prueba.roxxy.dtos.request.PayerGenericRequest;
import com.neivor.prueba.roxxy.enums.InvoiceStatus;
import com.neivor.prueba.roxxy.exceptions.InvoiceAmmountErrException;
import com.neivor.prueba.roxxy.exceptions.InvoiceNationalIdNotFoundException;
import com.neivor.prueba.roxxy.repository.contracts.IFacturaEntity;
import com.neivor.prueba.roxxy.repository.contracts.IPagadorEntity;
import com.neivor.prueba.roxxy.repository.entities.PagadorEntity;
import com.neivor.prueba.roxxy.service.contracts.IPayerService;
import lombok.var;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayerService implements IPayerService {
    private static final Logger LOGGER = LogManager.getLogger(PayerService.class);

    IFacturaEntity iFacturaEntity;
    IPagadorEntity iPagadorEntity;

    @Autowired
    public PayerService(IFacturaEntity iFacturaEntity, IPagadorEntity iPagadorEntity) {
        this.iFacturaEntity = iFacturaEntity;
        this.iPagadorEntity = iPagadorEntity;
    }

    @Override
    public int registerPayer(PayerGenericRequest payerRequest) throws InvoiceNationalIdNotFoundException, InvoiceAmmountErrException {
        try{
            LOGGER.info("Strat record Payer detail");
            var iFactura = iFacturaEntity.findByDocPagadorAndStatus(payerRequest.getPayerNationalId(), InvoiceStatus.PENDING.getInvoiceStatusCode());
            if(!iFactura.isPresent()){
                LOGGER.error("This national {} id dont have a Invoice", payerRequest.getPayerNationalId());
                throw new InvoiceNationalIdNotFoundException("We not found a Invoice for this national id ");
            }

            if (iFactura.get().getValorFactura() != payerRequest.getInvoiceAmmount()){
                LOGGER.error("This national {} id dont have a correct invoice ammount", payerRequest.getPayerNationalId());
                throw new InvoiceAmmountErrException( iFactura.get().getValorFactura());
            }

            var pagador = new PagadorEntity();

            pagador.setDocumentoPagador(payerRequest.getPayerNationalId());
            pagador.setNombrePagador(payerRequest.getPayerName());
            pagador.setValorFactura(iFactura.get().getValorFactura());
            pagador.setNumeroCasa(payerRequest.getHouseNumber());

            iPagadorEntity.save(pagador);


           return iFactura.get().getIdFactura();
        }catch (InvoiceNationalIdNotFoundException invoiceNationalIdNotFoundException){
            LOGGER.error("Error to register the Payer info ");
             throw invoiceNationalIdNotFoundException;
        }catch (InvoiceAmmountErrException invoiceAmmountErrException){
            LOGGER.error("Error to register the Payer info ");
            throw invoiceAmmountErrException;
        }
        catch (Exception e){
            LOGGER.error("Generic error to register payer info");
            throw e;
        }
    }
}
