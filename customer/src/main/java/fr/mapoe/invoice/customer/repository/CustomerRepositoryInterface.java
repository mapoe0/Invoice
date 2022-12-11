package fr.mapoe.invoice.customer.repository;

import fr.mapoe.invoise.core.entity.customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepositoryInterface extends CrudRepository<Customer, Long> {

}
