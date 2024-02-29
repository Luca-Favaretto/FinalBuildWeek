package team3.FinalBuildWeek.address;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
//                         @NotBlank(message = "Address name cannot be blank")
                         String address,
//                         @NotNull(message = "House number cannot be null")
//                         @Positive(message = "Postal code must be positive")
                         int number,
//                         @NotBlank(message = "Location cannot be empty")
                         String location,
//                         @Positive(message = "Postal code must be positive")
                         int postCode,
//                         @NotNull(message = "Municipality cannot be null")
                         String municipality,
                         @NotBlank(message = "BusinessName cannot be blank")
                         String businessName
                         ) {


}
