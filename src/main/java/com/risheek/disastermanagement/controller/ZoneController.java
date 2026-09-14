package com.risheek.disastermanagement.controller;

import com.risheek.disastermanagement.dto.UserResponse;
import com.risheek.disastermanagement.dto.ZoneRequest;
import com.risheek.disastermanagement.dto.ZoneResponse;
import com.risheek.disastermanagement.service.ZoneService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/zones")
public class ZoneController {

    private final ZoneService zoneService;

    public ZoneController(ZoneService zoneService){
        this.zoneService = zoneService;
    }

    @PostMapping("/create")
    public ResponseEntity<ZoneResponse> create (@Valid @RequestBody ZoneRequest zoneRequest){
        return ResponseEntity.status(201).body(zoneService.createZone(zoneRequest));
    }

    @GetMapping
    public ResponseEntity<List<ZoneResponse>> getCurrentZones() {
        return ResponseEntity.ok(zoneService.getCurrentZones());
    }

    @PutMapping
    public ResponseEntity<ZoneResponse> updateZone (@Valid @RequestBody ZoneRequest zoneRequest){
        return ResponseEntity.status(201).body(zoneService.updateZone(zoneRequest));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteZone(@Valid @RequestBody ZoneRequest zoneRequest){
        zoneService.deleteZone(zoneRequest.getName());
        return ResponseEntity.noContent().build();
    }

}
