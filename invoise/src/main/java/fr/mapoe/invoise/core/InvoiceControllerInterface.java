package fr.mapoe.invoise.core;

import fr.mapoe.invoise.core.service.InvoiceServiceInterface;

// Programation par contrat = créer une interface commune à plusieurs composant
public interface InvoiceControllerInterface {
    void createInvoice();
    void setInvoiceService(InvoiceServiceInterface invoiceService);
}
