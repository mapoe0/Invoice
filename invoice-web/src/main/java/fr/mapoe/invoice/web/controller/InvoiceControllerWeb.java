package fr.mapoe.invoice.web.controller;


import fr.mapoe.invoise.core.controller.InvoiceControllerInterface;
import fr.mapoe.invoise.core.entity.Invoice;
import fr.mapoe.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping("")
    public String createInvoice(@ModelAttribute("form") Invoice invoice) {
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

    // methode 2 pour retourner une page
    @GetMapping("/{id}")
    public ModelAndView displayInvoice(@PathVariable("id") String number) {
        System.out.println("methode displayInvoice called");
        ModelAndView mv = new ModelAndView("invoice-details");
        mv.addObject("invoice", invoiceService.getInvoiceByNumber(number));
        return mv;
    }

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute Invoice invoice) {
        return "invoice-create-form";
    }
}
