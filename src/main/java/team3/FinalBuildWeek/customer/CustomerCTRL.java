package team3.FinalBuildWeek.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerCTRL {

    @Autowired
    public CustomerSRV customerSRV;
    @PostMapping
    public Customer saveCustomer(CustomerDTO customerDTO){
        return customerSRV.save(customerDTO);
    }

}
