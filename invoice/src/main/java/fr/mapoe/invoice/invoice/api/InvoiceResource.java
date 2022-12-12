package fr.mapoe.invoice.invoice.api;


import fr.mapoe.invoise.core.entity.customer.Address;
import fr.mapoe.invoise.core.entity.customer.Customer;
import fr.mapoe.invoise.core.entity.invoice.Invoice;
import fr.mapoe.invoice.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

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





    public WebClient.Builder getWebClientBuilder() {
        return webClientBuilder;
    }

    public void setWebClientBuilder(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Autowired
    private WebClient.Builder webClientBuilder;

/*    @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        System.out.println("methode create (invoice) called");
        return invoiceService.createInvoice(invoice);
    }*/

    @GetMapping()
    public ParallelFlux<Invoice> list() {
        List<Mono<Invoice>> invoiceMonos = new ArrayList<>();
        final WebClient webClient = webClientBuilder.baseUrl("http://customer-service").build();
        Iterable<Invoice> invoices = invoiceService.getInvoiceList();
        invoices.forEach(invoice -> {
            invoiceMonos.add(
                    webClient.get()
                            .uri("/customer/" + invoice.getIdCustomer())
                            .retrieve().bodyToMono(Customer.class)
                            .map(customer -> {
                                invoice.setCustomer(customer);
                                return invoice;
                            })
            );

            /*String url = "http://customer-service/customer/" + invoice.getIdCustomer();
            invoice.setCustomer(restTemplate.getForObject(url, Customer.class));*/
        });
        final Flux<Invoice> invoiceFlux = Flux.concat(invoiceMonos);
        return invoiceFlux.parallel().runOn(Schedulers.elastic());
    }

    // methode 2 pour retourner une page
    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number) {
        Invoice invoice = invoiceService.getInvoiceByNumber(number);
        final WebClient webClient = webClientBuilder.baseUrl("http://customer-service").build();

        final Customer customer = webClient
                .get()
                .uri("/customer/" + invoice.getIdCustomer())
                .retrieve()
                .bodyToMono(Customer.class)
                .block();

        final Address address = webClient
                .get()
                .uri("/address/" + customer.getAddress().getId())
                .retrieve()
                .bodyToMono(Address.class)
                .block();

        customer.setAddress(address);
        invoice.setCustomer(customer);
        return invoice;

    }

}
