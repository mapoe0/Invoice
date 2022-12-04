package fr.mapoe.invoice.web.api;


import fr.mapoe.invoise.core.entity.Invoice;
import fr.mapoe.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    InvoiceServiceInterface invoiceService;

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        System.out.println("methode create (invoice) called");
        return invoiceService.createInvoice(invoice);
    }

    // methode 1 pour retourner une page
    @GetMapping()
    public Iterable<Invoice> list(Model model) {
        System.out.println("methode list (invoice) called");
        return invoiceService.getInvoiceList();
    }

    // methode 2 pour retourner une page
    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number) {
        System.out.println("methode get (invoice) called");
        return invoiceService.getInvoiceByNumber(number);
    }
/*
    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
        return "invoice-create-form";
    }*/
}
