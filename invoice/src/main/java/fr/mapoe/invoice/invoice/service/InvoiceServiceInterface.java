package fr.mapoe.invoice.invoice.service;

import fr.mapoe.invoice.invoice.repository.InvoiceRepositoryInterface;
import fr.mapoe.invoise.core.entity.invoice.Invoice;



public interface InvoiceServiceInterface {
    Invoice createInvoice(Invoice invoice);
    Iterable<Invoice> getInvoiceList();
    Invoice getInvoiceByNumber(String number);
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
}
