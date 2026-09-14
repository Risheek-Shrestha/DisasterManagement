package com.risheek.disastermanagement.repository;

import com.risheek.disastermanagement.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, String> {

    boolean existsByName(String name);

    Zone findByName(String name);
}
