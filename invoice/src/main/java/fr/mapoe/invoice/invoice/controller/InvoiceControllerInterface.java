package fr.mapoe.invoice.invoice.controller;

import fr.mapoe.invoice.invoice.service.InvoiceServiceInterface;
import fr.mapoe.invoise.core.entity.invoice.Invoice;

// Programation par contrat = créer une interface commune à plusieurs composant
public interface InvoiceControllerInterface {
    String createInvoice(Invoice invoice);
    void setInvoiceService(InvoiceServiceInterface invoiceService);
}
