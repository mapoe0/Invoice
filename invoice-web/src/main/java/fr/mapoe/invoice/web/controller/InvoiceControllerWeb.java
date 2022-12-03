package fr.mapoe.invoice.web.controller;


import fr.mapoe.invoise.core.InvoiceControllerInterface;
import fr.mapoe.invoise.core.entity.Invoice;
import fr.mapoe.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class InvoiceControllerWeb implements InvoiceControllerInterface {
    public InvoiceServiceInterface getInvoiceServiceMichel() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
    @Autowired
    InvoiceServiceInterface invoiceService;

    public void createInvoice() {
        String customerName = "Tesla";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        invoiceService.createInvoice(invoice);
    }
    @RequestMapping("/invoice-home")
    // @ModelAttribute = setAttribute
    public @ModelAttribute("invoices") List<Invoice> displayHome(/*HttpServletRequest request*/){
        System.out.println("methode displayHome called");
        List<Invoice> invoices = invoiceService.getInvoiceList();
        //request.setAttribute("invoices",invoices);
        // spring will by default redirect with attribute to a page "invoice-home.html"
        return invoices;
    }
}
