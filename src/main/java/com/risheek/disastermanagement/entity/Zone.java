package com.risheek.disastermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Enter approximate population density")
    @Column(nullable = false)
    private Long populationDensity;

    @NotNull(message = "Enter current severity score")
    @Column(nullable = false)
    private Integer severityScore;

    @Column
    private Integer severityHistory;

    @Enumerated(EnumType.STRING)
    @Column
    private RescueStatus rescueStatus;

}
