package fr.mapoe.invoice.web.controller;


import fr.mapoe.invoise.core.controller.InvoiceControllerInterface;
import fr.mapoe.invoise.core.entity.Invoice;
import fr.mapoe.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/invoice")
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
    // methode 1 pour retourner une page
    @RequestMapping("/home")
    public String displayHome(Model model){
        System.out.println("methode displayHome called");
        model.addAttribute("invoices",invoiceService.getInvoiceList());
        return "invoice-home";
    }
    // methode 2 pour retourner une page
    @RequestMapping("/{id}")
    public ModelAndView displayInvoice(@PathVariable("id") String number){
        System.out.println("methode displayInvoice called");
        ModelAndView mv = new ModelAndView("invoice-details");
        mv.addObject("invoice",invoiceService.getInvoiceByNumber(number));
        return mv;
    }
}
