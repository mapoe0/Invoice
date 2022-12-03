package fr.mapoe.invoise.core.service.number;

import fr.mapoe.invoise.core.entity.Invoice;
import fr.mapoe.invoise.core.repository.InvoiceRepositoryInterface;
import fr.mapoe.invoise.core.service.InvoiceServiceInterface;

import java.util.List;

//@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {
    private static long lastNumber = 0L;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    private InvoiceRepositoryInterface invoiceRepository;

    public void createInvoice(Invoice invoice){
        long nb = lastNumber+1;
        invoice.setNumber(String.valueOf(nb));
        invoiceRepository.create(invoice);
    }

    @Override
    public List<Invoice> getInvoiceList() {
        return invoiceRepository.list();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.getById(number);
    }
}
