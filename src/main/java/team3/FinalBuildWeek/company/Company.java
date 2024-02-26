package company;


import customer.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team3.FinalBuildWeek.address.Address;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue
    private UUID id;
    private String business_name;
    private String vat_number;
    private String email;
    private String phone_number;
    private String logo;
    private LocalDate insertion_date;
    private LocalDate last_contact_date;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String type;
    @OneToMany(mappedBy = "company" )
    private Set<Address> address;


    public Company(String business_name, String vat_number, String email, String phone_number, String logo, LocalDate insertion_date, LocalDate last_contact_date, Customer customer, String type) {
        this.business_name = business_name;
        this.vat_number = vat_number;
        this.email = email;
        this.phone_number = phone_number;
        this.logo = logo;
        this.insertion_date = insertion_date;
        this.last_contact_date = last_contact_date;
        this.customer = customer;
        this.type = type;
    }
}
