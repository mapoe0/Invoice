package fr.mapoe.invoise.core.repository;

import fr.mapoe.invoise.core.entity.invoice.Invoice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepositoryInterface extends CrudRepository<Invoice, String> {
    // jointure vers customer
    // @Query("SELECT invoice from Invoice invoice inner join fetch invoice.customer")
    @EntityGraph(value = "invoice.customer",type = EntityGraph.EntityGraphType.FETCH)
    Iterable<Invoice> findAll();
    /*Invoice create(Invoice invoice);
    List<Invoice> list();
    Invoice getById(String number);*/
}
