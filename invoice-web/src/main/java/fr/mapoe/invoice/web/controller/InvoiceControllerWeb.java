package fr.mapoe.invoice.web.controller;


import fr.mapoe.invoice.web.form.InvoiceForm;
import fr.mapoe.invoise.core.entity.customer.Address;
import fr.mapoe.invoise.core.entity.customer.Customer;
import fr.mapoe.invoise.core.entity.invoice.Invoice;
import fr.mapoe.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb {
    public InvoiceServiceInterface getInvoiceServiceMichel() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Autowired
    InvoiceServiceInterface invoiceService;

    @PostMapping("/create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results) {
        if (results.hasErrors()) {
            return "invoice-create-form";
        }
        Invoice invoice = new Invoice();
        Customer customer = new Customer(invoiceForm.getCustomerName());
        invoice.setCustomer(customer);
        Address address = new Address(invoiceForm.getStreetName(), invoiceForm.getStreetNumber(), invoiceForm.getCity(), invoiceForm.getZipCode(), invoiceForm.getCountry());
        customer.setAddress(address);
        invoice.setOrderNumber(invoiceForm.getOrderNumber());
        invoiceService.createInvoice(invoice);
        return "invoice-created";
    }

    // methode 1 pour retourner une page
    @GetMapping("/home")
    public String displayHome(Model model) {
        System.out.println("methode displayHome called");
        model.addAttribute("invoices", invoiceService.getInvoiceList());
        return "invoice-home";
    }
/*
    // methode 2 pour retourner une page
    @GetMapping("/{id}")
    public ModelAndView displayInvoice(@PathVariable("id") String number) {
        System.out.println("methode displayInvoice called");
        ModelAndView mv = new ModelAndView("invoice-details");
        mv.addObject("invoice", invoiceService.getInvoiceByNumber(number));
        return mv;
    }
*/

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
        return "invoice-create-form";
    }
}
