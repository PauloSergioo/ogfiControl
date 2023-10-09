package com.ogficontrol.demo.services;

import com.ogficontrol.demo.dto.DocumentDTO;
import com.ogficontrol.demo.entities.Document;
import com.ogficontrol.demo.repositories.DocumentRepository;
import com.ogficontrol.demo.repositories.ProjectRepository;
import com.ogficontrol.demo.services.exceptions.InvalidProjectIdException;
import com.ogficontrol.demo.services.validation.ProjectIdValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectDocumentService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DocumentRepository documentRepository;

    public List<DocumentDTO> getProjectDocument(Long projectId) {
        ProjectIdValidation.validateProjectId(projectId);
        List<Document> documents = documentRepository.findByProjectId(projectId);
        ProjectIdValidation.validateNonEmptyList(documents, "Empty document list for project: " + projectId);
        return documents.stream().map(DocumentDTO::new).collect(Collectors.toList());
    }
}
