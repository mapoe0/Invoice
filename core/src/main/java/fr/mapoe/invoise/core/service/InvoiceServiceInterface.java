package fr.mapoe.invoise.core.service;

import fr.mapoe.invoise.core.entity.Invoice;
import fr.mapoe.invoise.core.repository.InvoiceRepositoryInterface;


public interface InvoiceServiceInterface {
    Invoice createInvoice(Invoice invoice);
    Iterable<Invoice> getInvoiceList();
    Invoice getInvoiceByNumber(String number);
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
}
