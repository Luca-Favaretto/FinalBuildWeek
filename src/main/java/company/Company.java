package company;


import customer.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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

}
