package fr.mapoe.invoise.core.repository;

import fr.mapoe.invoise.core.entity.Invoice;

import java.util.List;

public interface InvoiceRepositoryInterface {
    void create(Invoice invoice);
    List<Invoice> list();
}
