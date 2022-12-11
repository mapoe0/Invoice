package fr.mapoe.invoice.invoice.repository;

import fr.mapoe.invoise.core.entity.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepositoryInterface extends CrudRepository<Invoice, String> {
}
