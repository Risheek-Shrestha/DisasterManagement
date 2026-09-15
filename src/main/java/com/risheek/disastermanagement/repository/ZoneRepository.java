package com.risheek.disastermanagement.repository;

import com.risheek.disastermanagement.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ZoneRepository extends JpaRepository<Zone, Long> {

    boolean existsByName(String name);
    Optional<Zone> findByName(String name);
}
