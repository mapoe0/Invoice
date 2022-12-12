package fr.mapoe.invoice.invoice.api;


import fr.mapoe.invoise.core.entity.customer.Address;
import fr.mapoe.invoise.core.entity.customer.Customer;
import fr.mapoe.invoise.core.entity.invoice.Invoice;
import fr.mapoe.invoice.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


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

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private RestTemplate restTemplate;

/*    @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        System.out.println("methode create (invoice) called");
        return invoiceService.createInvoice(invoice);
    }*/

    // methode 1 pour retourner une page
    @GetMapping()
    public Iterable<Invoice> list() {
        Iterable<Invoice> invoices = invoiceService.getInvoiceList();
        invoices.forEach(invoice -> {
            String url = "http://localhost:8081/customer/" + invoice.getIdCustomer();
            invoice.setCustomer(restTemplate.getForObject(url, Customer.class));
        });
        return invoices;
    }

    // methode 2 pour retourner une page
    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number) {
        Invoice invoice = invoiceService.getInvoiceByNumber(number);

        final String urlCustomer = "http://localhost:8081/customer/" + invoice.getIdCustomer();
        final Customer customer = restTemplate.getForObject(urlCustomer, Customer.class);

        final String urlAddress = "http://localhost:8081/address/"+customer.getAddress().getId();
        final Address address = restTemplate.getForObject(urlAddress,Address.class);

        customer.setAddress(address);
        invoice.setCustomer(customer);
        return invoice;

    }

}
