package team3.FinalBuildWeek.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyCTRL {
    @Autowired
    private CompanySRV companySRV;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Company saveCompany(@RequestBody CompanyDTO companyDTO){
        return companySRV.save(companyDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Company updateCompany(@PathVariable UUID id, @RequestBody CompanyDTO companyDTO){
        return companySRV.updateCompany(id,companyDTO);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public Page<Company> getAll(@RequestParam(defaultValue = "0") int pageNumber,
                                 @RequestParam(defaultValue = "10") int pageSize,
                                 @RequestParam(defaultValue = "business_name") String orderBy) {
        return companySRV.getAll(pageNumber, pageSize, orderBy);
    }

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
}
