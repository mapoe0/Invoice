package fr.mapoe.invoise.core.repository.database;

import fr.mapoe.invoise.core.entity.Invoice;
import fr.mapoe.invoise.core.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {

    private static List<Invoice> invoices = new ArrayList<Invoice>();

    public void create(Invoice invoice){
        invoices.add(invoice);
        System.out.println("Database: Invoice added with number: "+invoice.getNumber()+" for "+invoice.getCustomerName());
    }

    @Override
    public List<Invoice> list() {
        Invoice invoice1 = new Invoice();
        invoice1.setNumber("NUM_1");
        invoice1.setCustomerName("EDF");
        Invoice invoice2 = new Invoice();
        invoice2.setNumber("NUM_2");
        invoice2.setCustomerName("La poste");
        return Arrays.asList(invoice1,invoice2);
    }

    @Override
    public Invoice getById(String number) {
        Invoice invoice = new Invoice();
        invoice.setNumber(number);
        invoice.setCustomerName("EDF");
        invoice.setOrderNumber("ON_002");
        return invoice;
    }

}
