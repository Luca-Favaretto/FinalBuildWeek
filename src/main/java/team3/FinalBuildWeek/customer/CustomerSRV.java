package team3.FinalBuildWeek.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import team3.FinalBuildWeek.exceptions.NotFoundException;

import java.util.List;
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

    public Customer updateCustomer(UUID id,CustomerDTO customerDTO){
        Customer found = this.findCustomerById(id);
        found.setName(customerDTO.name());
        found.setEmail(customerDTO.email());
        found.setPhone(customerDTO.phone());
        found.setSurname(customerDTO.surname());
        return customerDAO.save(found);
    }

    public void deleteById(UUID id) {
        Customer found = this.findCustomerById(id);
        customerDAO.delete(found);
    }

    public Page<Customer> getAll(int pageNumber, int pageSize, String orderBy) {
        if (pageNumber > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(orderBy));
        return customerDAO.findAll(pageable);
    }

    public Customer findByEmail(String email){
        return customerDAO.findByEmail(email).orElseThrow(()-> new NotFoundException("customer non trovato"));
    }

    public List<Customer> getByAnnualRevenue(double value, int year){
        return customerDAO.getByAnnualRevenue(value, year);
    }


}
