package com.kampus.service.requests.userRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    //Validation Rules like @NotNull (jakarta.validation.constraints)

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

}
