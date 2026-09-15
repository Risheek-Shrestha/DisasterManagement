package com.risheek.disastermanagement.dto;

import com.risheek.disastermanagement.entity.RescueStatus;
import lombok.Data;

@Data
public class ZoneRequest {

    private Long id;
    private String name;
    private Long populationDensity;
    private Integer severityScore;
    private Integer severityHistory;
    private RescueStatus rescueStatus;

}
