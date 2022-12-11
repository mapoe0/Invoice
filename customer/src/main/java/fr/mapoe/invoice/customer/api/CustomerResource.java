package fr.mapoe.invoice.customer.api;


import fr.mapoe.invoice.customer.repository.CustomerRepositoryInterface;
import fr.mapoe.invoise.core.entity.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController /* = met auto le retour @ResponseBody*/
@RequestMapping("/customer")
public class CustomerResource {
    public CustomerRepositoryInterface getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepositoryInterface customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    private CustomerRepositoryInterface customerRepository;



    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") Long id){
        return customerRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
