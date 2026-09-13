package com.risheek.disastermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private ResourceType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RescueStatus status;

    @NotBlank(message = "Enter current location")
    @Column(nullable = false)
    private String location;

    @Column
    private Integer capacity;

}
