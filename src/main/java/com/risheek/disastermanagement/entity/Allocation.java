package com.risheek.disastermanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "allocations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "resource_id")
    private Resource resource;

    @JoinColumn(name = "zone_id")
    @Column
    private Zone zone;

    @Column
    private String decisionSource;

    @Column
    private LocalDateTime assignedTime;

    @Column
    private LocalDateTime resolvedTime;

    @Column
    private Integer outcomeMetrics;
}
