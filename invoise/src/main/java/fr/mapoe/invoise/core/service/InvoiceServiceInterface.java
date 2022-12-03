package fr.mapoe.invoise.core.service;

import fr.mapoe.invoise.core.entity.Invoice;
import fr.mapoe.invoise.core.repository.InvoiceRepositoryInterface;

import java.util.List;

public interface InvoiceServiceInterface {
    void createInvoice(Invoice invoice);
    List<Invoice> getInvoiceList();
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
}
