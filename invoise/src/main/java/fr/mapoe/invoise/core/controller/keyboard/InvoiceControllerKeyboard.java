package fr.mapoe.invoise.core.controller.keyboard;

import fr.mapoe.invoise.core.InvoiceControllerInterface;
import fr.mapoe.invoise.core.entity.Invoice;
import fr.mapoe.invoise.core.service.InvoiceServiceInterface;

import java.util.Scanner;
//@Controller
public class InvoiceControllerKeyboard implements InvoiceControllerInterface {

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public InvoiceServiceInterface invoiceService;
    public void createInvoice(){
        System.out.println( "What is customer name" );
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        invoiceService.createInvoice(invoice);
    }
}
