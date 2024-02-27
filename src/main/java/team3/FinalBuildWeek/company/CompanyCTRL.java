package team3.FinalBuildWeek.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyCTRL {
    @Autowired
    private CompanySRV companySRV;

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
        return companySRV.getAll(pageNumber, pageSize, orderBy);
    }

//    @GetMapping("/orderByInsertionDate")
//    @PreAuthorize("hasAuthority('USER')")
//    public Page<Company> getAllforContactDate(@RequestParam(defaultValue = "0") int pageNumber,
//                                 @RequestParam(defaultValue = "10") int pageSize,
//                                 @RequestParam(defaultValue = "last_contact_date") String orderBy) {
//        return companySRV.getAll(pageNumber, pageSize, orderBy);
//    }

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


    @GetMapping
    public List<Object[]> getCompanyForAmount(){
        return companySRV.getAziendeOrdinatePerFatturatoAnnuo();
    }
}
