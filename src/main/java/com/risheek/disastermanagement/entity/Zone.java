package com.risheek.disastermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "zones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Enter location name")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Enter approximate population density")
    @Column(nullable = false)
    private Long populationDensity;

    @NotBlank(message = "Enter current severity score")
    @Column(nullable = false)
    private Integer severityScore;

    @Column
    private Integer severityHistory;

    @Enumerated(EnumType.STRING)
    @Column
    private RescueStatus rescueStatus;

}
