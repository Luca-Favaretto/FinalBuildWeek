package team3.FinalBuildWeek.company;

import team3.FinalBuildWeek.enums.Type;

import java.time.LocalDate;

public record CompanyDTO(
//        @NotBlank(message = "Business name cannot be blank")
        String business_name,
//        @NotBlank(message = "VAT number cannot be blank")
        String vat_number,
//        @Email(message = "Please provide a valid email address")
        String email,
//        @NotBlank(message = "Phone number cannot be blank")
        String phone_number,
        String logo,

//        @NotNull(message = "Insertion date cannot be null")
        LocalDate insertion_date,
        LocalDate last_contact_date,
//        @Email(message = "Please provide a valid customer email address")
        String customer_email,
//        @NotBlank(message = "Company type cannot be blank")
        String type) {
    public Type getType() {
        try {
            return Type.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Type value: " + type + ".Correct value: PA," + "SAS," +"SRL," +"SPA");
        }
    }

}
