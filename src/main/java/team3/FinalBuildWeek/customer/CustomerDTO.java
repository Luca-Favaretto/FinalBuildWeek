package team3.FinalBuildWeek.customer;

public record CustomerDTO(
//        @NotBlank(message = "Customer name cannot be blank")
        String name,
//        @NotBlank(message = "Customer surname cannot be blank")
        String surname,
//        @NotBlank(message = "Phone number cannot be blank")
        String phone,
//        @Email(message = "Please provide a valid email address")
        String email) {
}
