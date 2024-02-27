package team3.FinalBuildWeek.Invoice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import team3.FinalBuildWeek.customer.Customer;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;
    private LocalDate date;
    private double amount;
    private String invoiceNumber;
    private String invoiceStatus;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Invoice(LocalDate date, double amount, String invoiceNumber, String invoiceStatus, Customer customer) {
        this.date = date;
        this.amount = amount;
        this.invoiceNumber = invoiceNumber;
        this.invoiceStatus = invoiceStatus;
        this.customer = customer;
    }
}
