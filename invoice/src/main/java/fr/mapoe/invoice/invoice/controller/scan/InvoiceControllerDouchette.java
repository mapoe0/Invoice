package fr.mapoe.invoice.invoice.controller.scan;

import fr.mapoe.invoice.invoice.controller.InvoiceControllerInterface;
import fr.mapoe.invoice.invoice.service.InvoiceServiceInterface;
import fr.mapoe.invoise.core.entity.customer.Customer;
import fr.mapoe.invoise.core.entity.invoice.Invoice;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {
    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    private InvoiceServiceInterface invoiceService;

    public String createInvoice(Invoice invoice) {
        System.out.println("Usage of a scanner");
        invoice = new Invoice();
        Customer customer = new Customer("Virgin Galactic");
        invoice.setCustomer(customer);
        return null;
    }
}
