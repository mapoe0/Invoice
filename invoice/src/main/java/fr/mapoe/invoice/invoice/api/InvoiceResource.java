package fr.mapoe.invoice.invoice.api;


import fr.mapoe.invoise.core.entity.customer.Customer;
import fr.mapoe.invoise.core.entity.invoice.Invoice;
import fr.mapoe.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController /* = met auto le retour @ResponseBody*/
@RequestMapping("/invoice")
public class InvoiceResource {
    public InvoiceServiceInterface getInvoiceServiceMichel() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Autowired
    private InvoiceServiceInterface invoiceService;

/*    @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        System.out.println("methode create (invoice) called");
        return invoiceService.createInvoice(invoice);
    }*/

    // methode 1 pour retourner une page
    @GetMapping()
    public Iterable<Invoice> list() {
        List<Invoice> invoiceList = new ArrayList<>();

        Customer customer = new Customer("Lambda");
        Invoice invoice = new Invoice("NUM_001","001",customer);
        invoiceList.add(invoice);
        return invoiceList;
    }

/*    // methode 2 pour retourner une page
    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number) {
        System.out.println("methode get (invoice) called");
        return invoiceService.getInvoiceByNumber(number);
    }*/

}
