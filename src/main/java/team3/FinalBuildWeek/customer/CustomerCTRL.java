package team3.FinalBuildWeek.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerCTRL {

    @Autowired
    public CustomerSRV customerSRV;
    @Autowired
    private CustomerDAO customerDAO;

    @PostMapping
    public Customer saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerSRV.save(customerDTO);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable UUID id,@RequestBody CustomerDTO customerDTO,@AuthenticationPrincipal Customer customer){
        return customerSRV.updateCustomer(id,customerDTO,customer);
    }

    @DeleteMapping("/{id}")
        public void deleteCustomer(@PathVariable UUID id, @AuthenticationPrincipal Customer customer) throws AccessDeniedException {
        if (!id.equals(customer.getId())) {
            throw new AccessDeniedException("Non hai i permessi per eliminare questo profilo");
        }
        customerSRV.deleteById(id,customer);
    }

    @GetMapping("/{id}")
    public Customer findByid(@PathVariable UUID id){
        return customerSRV.findCustomerById(id);
    }

}
