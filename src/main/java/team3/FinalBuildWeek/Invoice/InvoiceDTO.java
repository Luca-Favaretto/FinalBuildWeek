package team3.FinalBuildWeek.Invoice;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record InvoiceDTO(
        @NotNull(message = "Invoice date cannot be null")
         LocalDate date,
       @Positive(message = "Invoice amount must be positive")
         double amount,
        @NotBlank(message = "Invoice number cannot be blank")
         String invoiceNumber,
        @NotBlank(message = "Invoice status cannot be blank")
         String invoiceStatus,
        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Please provide a valid email address")
         String email
) {

}