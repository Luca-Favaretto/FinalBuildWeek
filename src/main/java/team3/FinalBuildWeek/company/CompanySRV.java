package team3.FinalBuildWeek.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import team3.FinalBuildWeek.customer.Customer;
import team3.FinalBuildWeek.customer.CustomerDAO;
import team3.FinalBuildWeek.exceptions.NotFoundException;

@Service
public class CompanySRV {
    @Autowired
    private CompanyDAO companyDAO;

    @Autowired
    private CustomerDAO customerDAO;

    public Company save(CompanyDTO companyDTO) {
        Customer customer = customerDAO.findByEmail(companyDTO.customer_email()).orElseThrow(()-> new NotFoundException(companyDTO.email()));
        Company company= new Company(companyDTO.business_name(), companyDTO.vat_number(),companyDTO.email(), companyDTO.phone_number(), companyDTO.logo(), companyDTO.insertion_date(),companyDTO.last_contact_date(),customer,companyDTO.type());
        return companyDAO.save(company);
    }

    public Page<Company> getAll(int pageNumber, int pageSize, String orderBy) {
        if (pageNumber > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(orderBy));
        return companyDAO.findAll(pageable);
    }


}
