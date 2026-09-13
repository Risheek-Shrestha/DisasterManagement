package com.risheek.disastermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username required")
    @Column(nullable = false)
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank(message = "Email address required")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 50)
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.FIELDRESPONDER;

    private String associatedZone;
}
