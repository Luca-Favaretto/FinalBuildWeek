package team3.FinalBuildWeek.Invoice;

import jakarta.persistence.*;
import lombok.*;
import team3.FinalBuildWeek.customer.Customer;

import java.sql.Date;
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
    @Column(name = "id")
    private UUID id;
    private Date date;
    private double amount;
    private String invoiceNumber;
    private char invoiceStatus;
    @ManyToOne
    private Customer customer;

    public Invoice(Date date, double amount, String invoiceNumber, char invoiceStatus, Customer customer) {
        this.date = date;
        this.amount = amount;
        this.invoiceNumber = invoiceNumber;
        this.invoiceStatus = invoiceStatus;
        this.customer = customer;
    }
}
