package fr.mapoe.invoise.core.repository.memory;

import fr.mapoe.invoise.core.controller.entity.Invoice;
import fr.mapoe.invoise.core.repository.InvoiceRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
//@Repository
public class InvoiceRepositoryMemory implements InvoiceRepositoryInterface {

    private static List<Invoice> invoices = new ArrayList<Invoice>();

    public Invoice create(Invoice invoice){
        invoices.add(invoice);
        System.out.println("Invoice added with number: "+invoice.getNumber()+" for "+invoice.getCustomerName());
        return invoice;
    }

    @Override
    public List<Invoice> list() {
        return null;
    }

    @Override
    public Invoice getById(String number) {
        throw  new UnsupportedOperationException();
    }
}
