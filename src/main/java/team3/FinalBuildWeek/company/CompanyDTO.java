package team3.FinalBuildWeek.company;

import team3.FinalBuildWeek.enums.Type;

import java.time.LocalDate;

public record CompanyDTO(String business_name, String vat_number, String email, String phone_number, String logo, LocalDate insertion_date, LocalDate last_contact_date,String customer_email, Type type) {
}
