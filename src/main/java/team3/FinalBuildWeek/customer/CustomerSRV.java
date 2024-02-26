package team3.FinalBuildWeek.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSRV {

    @Autowired
    CustomerDAO customerDAO;

    public Customer save(CustomerDTO customerDTO) {
        Customer customer= new Customer(customerDTO.name(), customerDTO.surname(),customerDTO.email(), customerDTO.phone() );
        return customerDAO.save(customer);
    }
}
