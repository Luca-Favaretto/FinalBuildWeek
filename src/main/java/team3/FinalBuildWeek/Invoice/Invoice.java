package team3.FinalBuildWeek.Invoice;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
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
    private Cliente cliente;
}
