package team3.FinalBuildWeek.customer;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team3.FinalBuildWeek.Invoice.Invoice;
import team3.FinalBuildWeek.company.Company;

import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    @JsonIgnore
    @OneToOne(mappedBy = "customer")
    private Company company;
    @OneToMany(mappedBy = "customer")
    private Set<Invoice> invoices;

    public Customer(String name, String surname, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }
}
