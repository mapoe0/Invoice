package fr.mapoe.invoise.core.repository;

import fr.mapoe.invoise.core.controller.entity.Invoice;

import java.util.List;

public interface InvoiceRepositoryInterface {
    Invoice create(Invoice invoice);
    List<Invoice> list();
    Invoice getById(String number);
}
