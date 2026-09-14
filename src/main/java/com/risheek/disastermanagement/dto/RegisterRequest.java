package com.risheek.disastermanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterRequest {

    @NotBlank(message = "Username required")
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank(message = "Email address required")
    @Email(message = "Invalid email format")
    @Size(min = 3, max = 50)
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    private String associatedZone;
}