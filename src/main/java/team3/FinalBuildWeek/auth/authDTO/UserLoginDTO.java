package team3.FinalBuildWeek.auth.authDTO;

public record UserLoginDTO(
//        @NotEmpty(message = "Email is required")
//        @Email(message = "Email address you provided is not valid.")
        String email,

//        @NotEmpty(message = "Password is required")
//        @Size(min = 8, message = "Password must be at least 8 characters long")
        String password) {
}
