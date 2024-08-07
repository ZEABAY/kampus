package com.kampus.service.requests.authRequests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest { /* CREATE USER REQUEST */

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    String username;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    String password;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    String mail;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    String firstName;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    String lastName;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    String phoneNumber;

    @NotNull
    Date birthDate;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    String permission;
}