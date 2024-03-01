package team3.FinalBuildWeek.auth.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotEmpty(message = "Name is required!")
        @Size(min = 3, max = 20, message = "Name must be 3 to 20 characters long ")
        String name,
        @NotEmpty(message = "Surname is required!")
        @Size(min = 3, max = 20, message = "Surname must be 3 to 20 characters long")
        String surname,
        @NotEmpty(message = "Username is required!")
        @Size(min = 3, max = 20, message = "Username must be 3 to 20 characters long")
        String username,
        @NotEmpty(message = "Password is required")
        @Size(min = 3, max = 20, message = "Password must be 3 to 20 characters long")
        String password,
        @NotEmpty(message = "Email is required")
        @Email(message = "Email address you provided is not valid.")
        String email) {
}
