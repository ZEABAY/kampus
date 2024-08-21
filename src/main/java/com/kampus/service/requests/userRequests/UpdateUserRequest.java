package com.kampus.service.requests.userRequests;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @Size(min = 3, max = 16, message = "Username must be between 3 and 16 characters")
    private String username;

    @Size(min = 8, message = "Password should be at least 8 characters long")
    private String password;

    @Pattern(regexp = "^\\d{11}@ogr\\.inonu\\.edu\\.tr$")
    private String email;


    @Size(min = 3, max = 16, message = "First name must be between 3 and 16 characters")
    private String firstName;


    @Size(min = 3, max = 16, message = "Last name must be between 3 and 16 characters")
    private String lastName;


    @Pattern(regexp = "^(?:\\+90|0)?(?:\\d{3})\\d{7}$", message = "Phone number must be in the format of 10-digit Turkish phone number with optional +90 or 0 prefix")
    private String phoneNumber;

}
