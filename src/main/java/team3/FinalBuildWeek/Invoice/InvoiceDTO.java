package team3.FinalBuildWeek.Invoice;

import java.sql.Date;
import java.time.LocalDate;

public record InvoiceDTO(
         LocalDate date,
         double amount,
         String invoiceNumber,
         String invoiceStatus,
         String email
) {

}