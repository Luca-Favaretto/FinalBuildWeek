package team3.FinalBuildWeek.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyCTRL {
    @Autowired
    private CompanySRV companySRV;

    @PostMapping
    public Company saveCompany(@RequestBody CompanyDTO companyDTO){
        return companySRV.save(companyDTO);
    }
}
