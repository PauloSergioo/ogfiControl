package com.ogficontrol.demo.repositories;

import com.ogficontrol.demo.entities.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostRepository extends JpaRepository<Cost, Long> {

    List<Cost> findByProjectId(Long projectId);
}
