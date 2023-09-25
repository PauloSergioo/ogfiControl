package com.ogficontrol.demo.resources;

import com.ogficontrol.demo.dto.DocumentDTO;
import com.ogficontrol.demo.services.ProjectDocumentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
@Tag(name = "ProjectsDocuments", description = "Controller for Projects Documents")
public class ProjectDocumentResource {

    @Autowired
    private ProjectDocumentService documentService;

    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}/documents")
    public ResponseEntity<List<DocumentDTO>> getDocumentsByProjectId(@PathVariable Long id) {
        List<DocumentDTO> documents = documentService.getProjectDocument(id);
        return ResponseEntity.ok(documents);
    }
}
