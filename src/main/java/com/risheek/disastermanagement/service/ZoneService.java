package com.risheek.disastermanagement.service;

import com.risheek.disastermanagement.dto.ZoneRequest;
import com.risheek.disastermanagement.dto.ZoneResponse;
import com.risheek.disastermanagement.entity.Zone;
import com.risheek.disastermanagement.exception.ZoneAlreadyExistsException;
import com.risheek.disastermanagement.exception.ZoneNotFoundException;
import com.risheek.disastermanagement.repository.ZoneRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ZoneService {

    private final ZoneRepository zoneRepository;

    public ZoneService(ZoneRepository zoneRepository){
        this.zoneRepository = zoneRepository;
    }

    public ZoneResponse createZone(@RequestBody ZoneRequest zoneRequest) {

        if(zoneRepository.existsByName(zoneRequest.getName())){
            throw new ZoneAlreadyExistsException("Zone Already Exists");
        }

        Zone zone = new Zone();
        zone.setName(zoneRequest.getName());
        zone.setPopulationDensity(zoneRequest.getPopulationDensity());
        zone.setSeverityScore(zoneRequest.getSeverityScore());
        zone.setSeverityHistory(zoneRequest.getSeverityHistory());
        zone.setRescueStatus(zoneRequest.getRescueStatus());

        zoneRepository.save(zone);

        return ZoneResponse.from(zone);
    }


    public List<ZoneResponse> getCurrentZones() {

        List<Zone> zone = zoneRepository.findAll();

        return zone.stream()
                .map(ZoneResponse::from)
                .toList();
    }


    public ZoneResponse updateZone(@Valid ZoneRequest zoneRequest) {

        Zone zone = zoneRepository.findByName(zoneRequest.getName())
                .orElseThrow(()-> new ZoneNotFoundException("Zone Does Not Exist"));

        zone.setPopulationDensity(zoneRequest.getPopulationDensity());
        zone.setSeverityScore(zoneRequest.getSeverityScore());
        zone.setSeverityHistory(zoneRequest.getSeverityHistory());
        zone.setRescueStatus(zoneRequest.getRescueStatus());

        zoneRepository.save(zone);

        return ZoneResponse.from(zone);

    }

    public void deleteZone(String name) {

        Zone zone = zoneRepository.findByName(name)
                .orElseThrow(()-> new ZoneNotFoundException("Zone Does Not Exist"));

        zoneRepository.delete(zone);

    }
}
