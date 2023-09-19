package com.ogficontrol.demo.repositories;

import com.ogficontrol.demo.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ProjectRepository extends JpaRepository<Project, Long> {

        @Query("SELECT p FROM Project p WHERE (:projectName is null OR p.projectName LIKE %:projectName%)")
        Page<Project> findAllByProjectName(String projectName, Pageable pageable);
    }