package fr.mapoe.invoise.core.repository;

import fr.mapoe.invoise.core.entity.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepositoryInterface extends CrudRepository<Invoice,String> {
    /*Invoice create(Invoice invoice);
    List<Invoice> list();
    Invoice getById(String number);*/
}
