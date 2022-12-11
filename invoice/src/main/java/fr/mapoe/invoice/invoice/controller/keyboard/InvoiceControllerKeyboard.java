package fr.mapoe.invoice.invoice.controller.keyboard;

import fr.mapoe.invoice.invoice.controller.InvoiceControllerInterface;
import fr.mapoe.invoice.invoice.service.InvoiceServiceInterface;
import fr.mapoe.invoise.core.entity.customer.Customer;
import fr.mapoe.invoise.core.entity.invoice.Invoice;


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
    public String createInvoice(Invoice invoice){
        System.out.println("What is the customer name ?");
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        invoice = new Invoice();
        Customer customer = new Customer(customerName);
        invoice.setCustomer(customer);
        return null;
    }
}
