package team3.FinalBuildWeek.customer;


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
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany
    private Set<Invoice> invoices;

    public Customer(String name, String surname, String phone, String email, Company company) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.company = company;
    }
}
