package team3.FinalBuildWeek.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.FinalBuildWeek.exceptions.NotFoundException;

import java.util.UUID;

@Service
public class CustomerSRV {

    @Autowired
    CustomerDAO customerDAO;

    public Customer save(CustomerDTO customerDTO) {
        Customer customer= new Customer(customerDTO.name(), customerDTO.surname(), customerDTO.phone(),customerDTO.email() );
        return customerDAO.save(customer);
    }

    public Customer findCustomerById(UUID id){
        return customerDAO.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public Customer updateCustomer(UUID id,CustomerDTO customerDTO,Customer customer){
        Customer found = this.findCustomerById(id);
        found.setName(customerDTO.name());
        found.setEmail(customerDTO.email());
        found.setPhone(customerDTO.phone());
        found.setSurname(customerDTO.surname());
        return customerDAO.save(found);
    }

    public void deleteById(UUID id, Customer customer) {
        Customer found = this.findCustomerById(id);
        customerDAO.delete(found);
    }
}
