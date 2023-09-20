package com.ogficontrol.demo.repositories;

import com.ogficontrol.demo.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByProjectId(Long projectId);
}
