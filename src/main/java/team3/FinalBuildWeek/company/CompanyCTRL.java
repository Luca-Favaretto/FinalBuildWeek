package team3.FinalBuildWeek.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyCTRL {
    @Autowired
    private CompanySRV companySRV;
    @Autowired
    private CompanyDAO companyDAO;

    @PostMapping

    public Company saveCompany(@RequestBody CompanyDTO companyDTO){
        return companySRV.save(companyDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Company updateCompany(@PathVariable UUID id, @RequestBody CompanyDTO companyDTO){
        return companySRV.updateCompany(id,companyDTO);
    }

    @GetMapping("/orderByName")
    @PreAuthorize("hasAuthority('USER')")
    public Page<Company> getAllforName(@RequestParam(defaultValue = "0") int pageNumber,
                                       @RequestParam(defaultValue = "10") int pageSize,
                                       @RequestParam(defaultValue = "business_name") String orderBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(orderBy));
        return companyDAO.getAllOrderedByName(pageable);
    }

    @GetMapping("/orderByInsertionDate")
    @PreAuthorize("hasAuthority('USER')")
    public Page<Company> getAllforContactDate(@RequestParam(defaultValue = "0") int pageNumber,
                                 @RequestParam(defaultValue = "10") int pageSize,
                                 @RequestParam(defaultValue = "insertion_date") String orderBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(orderBy));
        return companyDAO.getAllOrderedByInsertionDate(pageable);
    }

//    @GetMapping("/orderByInsertionDate")
//    @PreAuthorize("hasAuthority('USER')")
//    public Page<Company> getAllforInsertionDate(@RequestParam(defaultValue = "0") int pageNumber,
//                                 @RequestParam(defaultValue = "10") int pageSize,
//                                 @RequestParam(defaultValue = "insertion_date") String orderBy) {
//        return companySRV.getAll(pageNumber, pageSize, orderBy);
//    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Company findById(@PathVariable UUID id){
        return companySRV.findCompanyById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteCompany(@PathVariable UUID id){
         companySRV.deleteCompany(id);
    }


    @GetMapping("/orderForAmount")
    public List<Object[]> getInvoicesOrderedByAmount() {
        return companySRV.getAziendeOrdinatePerFatturatoAnnuo();
    }

    @GetMapping("/orderByPartialName")
    @PreAuthorize("hasAuthority('USER')")
    public List<Company> getCompaniesByPartialName(@RequestParam(name = "partialName") String partialName) {
       return companySRV.getCompaniesByPartialName(partialName);
    }
}
