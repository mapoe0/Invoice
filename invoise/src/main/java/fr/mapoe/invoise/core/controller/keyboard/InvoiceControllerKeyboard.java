package fr.mapoe.invoise.core.controller.keyboard;

import fr.mapoe.invoise.core.controller.InvoiceControllerInterface;
import fr.mapoe.invoise.core.controller.entity.Invoice;
import fr.mapoe.invoise.core.service.InvoiceServiceInterface;

//@Controller
public class InvoiceControllerKeyboard implements InvoiceControllerInterface {

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public InvoiceServiceInterface invoiceService;
    public String createInvoice(Invoice invoice){
        return null;
    }
}
