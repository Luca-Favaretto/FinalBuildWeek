package team3.FinalBuildWeek.Invoice;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record InvoiceDTO() {
    @NotEmpty(message = "La data della fattura è obbligatoria")
    @Size(min = 6, max = 8, message = "")
     private static Date date;
    @NotEmpty(message = "L'importo della fattura è obbligatorio")
    @Size(min = )
    private static double amount;
    @NotEmpty(message = "Il numero della fattura è obbligatorio")
    @Size(min = )
    private static String invoiceNumber;
    @NotEmpty(message = "Il cliente della fattura è obbligatorio")
    @Size(min = )
    private static String customer;
}