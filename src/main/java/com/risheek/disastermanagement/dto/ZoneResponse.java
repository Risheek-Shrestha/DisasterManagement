package com.risheek.disastermanagement.dto;

import com.risheek.disastermanagement.entity.RescueStatus;
import com.risheek.disastermanagement.entity.User;
import com.risheek.disastermanagement.entity.Zone;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ZoneResponse {

    private Long id;
    private String name;
    private Long populationDensity;
    private Integer severityScore;
    private Integer severityHistory;
    private RescueStatus rescueStatus;

    public static ZoneResponse from(Zone zone) {


        return ZoneResponse.builder()
                .id(zone.getId())
                .name(zone.getName())
                .severityScore(zone.getSeverityScore())
                .severityHistory(zone.getSeverityHistory())
                .populationDensity(zone.getPopulationDensity())
                .rescueStatus(zone.getRescueStatus())
                .build();
    }

}
