package team3.FinalBuildWeek.auth.authDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserLoginDTO(
        @NotBlank(message = "Email is required")
        @Email(message = "Email address you provided is not valid.")
        String email,

        @NotEmpty(message = "Password is required")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        String password) {
}
