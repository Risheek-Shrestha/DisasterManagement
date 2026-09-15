package com.risheek.disastermanagement.repository;

import com.risheek.disastermanagement.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
