package fr.mapoe.invoice.customer.api;


import fr.mapoe.invoice.customer.repository.AddressRepositoryInterface;
import fr.mapoe.invoise.core.entity.customer.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/address")
public class AddressResource {
    public AddressRepositoryInterface getAddressRepository() {
        return addressRepository;
    }

    public void setAddressRepository(AddressRepositoryInterface addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Autowired
    private AddressRepositoryInterface addressRepository;


    @GetMapping("/{id}")
    public Address get(@PathVariable("id") Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
