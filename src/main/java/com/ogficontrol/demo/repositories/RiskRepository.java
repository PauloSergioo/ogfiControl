package com.ogficontrol.demo.repositories;

import com.ogficontrol.demo.entities.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiskRepository extends JpaRepository<Risk, Long> {

    List<Risk> findByProjectId(Long projectId);
}

