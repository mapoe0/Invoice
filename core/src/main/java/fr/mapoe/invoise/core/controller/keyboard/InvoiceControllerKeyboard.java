package fr.mapoe.invoise.core.controller.keyboard;

import fr.mapoe.invoise.core.controller.InvoiceControllerInterface;
import fr.mapoe.invoise.core.entity.Customer;
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
