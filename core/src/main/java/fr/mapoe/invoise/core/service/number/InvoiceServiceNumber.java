package fr.mapoe.invoise.core.service.number;

import fr.mapoe.invoise.core.entity.invoice.Invoice;
import fr.mapoe.invoise.core.repository.InvoiceRepositoryInterface;
import fr.mapoe.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {


    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


    @Autowired
    private InvoiceRepositoryInterface invoiceRepository;
//    @Autowired
//    private CustomerRepositoryInterface customerRepositoryInterface;
    @Transactional
    public Invoice createInvoice(Invoice invoice){
        //customerRepositoryInterface.save(invoice.getCustomer());
        return invoiceRepository.save(invoice);
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {

        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.findById(number).orElseThrow();
    }
}
