package team3.FinalBuildWeek.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public Customer saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerSRV.save(customerDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Customer updateCustomer(@PathVariable UUID id,@RequestBody CustomerDTO customerDTO){
        return customerSRV.updateCustomer(id,customerDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
        public void deleteCustomer(@PathVariable UUID id) throws AccessDeniedException {
        customerSRV.deleteById(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Customer findByid(@PathVariable UUID id){
        return customerSRV.findCustomerById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public Page<Customer> getAll(@RequestParam(defaultValue = "0") int pageNumber,
                             @RequestParam(defaultValue = "10") int pageSize,
                             @RequestParam(defaultValue = "name") String orderBy) {
        return customerSRV.getAll(pageNumber, pageSize, orderBy);
    }

}
