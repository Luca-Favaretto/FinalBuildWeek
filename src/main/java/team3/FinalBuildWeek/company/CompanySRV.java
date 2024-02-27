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

import java.util.List;
import java.util.UUID;

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

    public Company findCompanyById(UUID id){
        return companyDAO.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public void deleteCompany(UUID id){
        Company found = this.findCompanyById(id);
        companyDAO.delete(found);
    }

    public Company updateCompany(UUID id,CompanyDTO companyDTO){
        Company found = this.findCompanyById(id);
        found.setBusiness_name(companyDTO.business_name());
        found.setVat_number(companyDTO.vat_number());
        found.setEmail(companyDTO.email());
        found.setPhone_number(companyDTO.phone_number());
        found.setLogo(companyDTO.logo());
        found.setInsertion_date(companyDTO.insertion_date());
        found.setLast_contact_date(companyDTO.last_contact_date());
        found.setType(companyDTO.type());
       return companyDAO.save(found);
    }

    public List<Object[]> getAziendeOrdinatePerFatturatoAnnuo() {
        return companyDAO.getAziendeOrdinatePerFatturatoAnnuo();
    }


}
