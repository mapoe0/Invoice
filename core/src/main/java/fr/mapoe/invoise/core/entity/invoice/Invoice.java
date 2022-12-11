package fr.mapoe.invoise.core.entity.invoice;


import fr.mapoe.invoise.core.entity.customer.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
// déclare la jointure si c'est demandé par le répo
//@NamedEntityGraph(name = "invoice.customer",attributeNodes = @NamedAttributeNode("customer"))
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="INVOICE_NUMBER",columnDefinition="BIGINT")
    private String number;
    @Column(length = 13)
    private String orderNumber;

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    private Long idCustomer;
    // Transient = do not use this
    @Transient
    private Customer customer;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "INVOICE_NUMBER", nullable = false)
    private List<InvoiceLine> lines=new ArrayList<>();

    public Invoice(String number, String orderNumber, Customer customer) {
        this.number = number;
        this.orderNumber = orderNumber;
        this.customer = customer;
    }

    public Invoice(String number, Customer customer) {
        this.number = number;
        this.customer = customer;
    }

    public Invoice(Customer customer) {
        this.customer = customer;
    }

    public Invoice() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void addLine(InvoiceLine line) {
        this.lines.add(line);
    }

    public void removeLine(InvoiceLine line) {
        this.lines.remove(line);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
