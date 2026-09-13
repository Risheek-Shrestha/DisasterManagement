package com.risheek.disastermanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "incidents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "zone_id")
    private Zone zone;

    @Column(nullable = false)
    private LocalDateTime reportedTime;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String reporter;

    @Column(nullable = false)
    private Integer severityScoreAtReportingTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RescueStatus rescueStatus;

}
