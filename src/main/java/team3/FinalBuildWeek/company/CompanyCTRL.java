package team3.FinalBuildWeek.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import team3.FinalBuildWeek.exceptions.BadRequestException;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyCTRL {
    @Autowired
    private CompanySRV companySRV;
    @Autowired
    private CompanyDAO companyDAO;

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public Page<Company> getAll(@RequestParam(defaultValue = "0") int pageNumber,
                                 @RequestParam(defaultValue = "10") int pageSize,
                                 @RequestParam(defaultValue = "id") String orderBy) {
        return companySRV.getAll(pageNumber, pageSize, orderBy);
    }


    @PostMapping
    public Company saveCompany(@RequestBody @Validated CompanyDTO companyDTO, BindingResult validation)throws IOException {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
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


    @GetMapping({"/insDate/{date}"})
    public List<Company> findCompanyByInsertDate (@PathVariable LocalDate date) {
        return companySRV.findCompanyByInsertDate(date);
    }@GetMapping({"/lastDate/{date}"})
    public List<Company> findCompanyByLastContactDate (@PathVariable LocalDate date) {
        return companySRV.findCompanyByLastContactDate(date);
    }
    @GetMapping("/orderByPartialName")
    @PreAuthorize("hasAuthority('USER')")
    public List<Company> getCompaniesByPartialName(@RequestParam String partialName) {
       return companySRV.getCompaniesByPartialName(partialName);

    }
    @GetMapping("/orderByProvince")
    @PreAuthorize("hasAuthority('USER')")
    public List<Company> orderByProvince(){
        return companySRV.orderByProvince();
    };
}
