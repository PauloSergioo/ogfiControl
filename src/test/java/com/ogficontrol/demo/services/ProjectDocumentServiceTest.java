package com.ogficontrol.demo.services;

import com.ogficontrol.demo.dto.DocumentDTO;
import com.ogficontrol.demo.entities.Document;
import com.ogficontrol.demo.repositories.DocumentRepository;
import com.ogficontrol.demo.repositories.ProjectRepository;
import com.ogficontrol.demo.services.exceptions.InvalidProjectIdException;
import com.ogficontrol.demo.services.exceptions.ResourceNotFoundException;
import com.ogficontrol.demo.tests.ProjectDocumentFactory;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class ProjectDocumentServiceTest {

    @InjectMocks
    private ProjectService service;

    @InjectMocks
    private ProjectDocumentService documentService;

    @Mock
    private ProjectRepository repository;

    @Mock
    private DocumentRepository documentRepository;

    private long existingProjectId;
    private long negativeProjectId;

    @BeforeEach
    void setUp() {

        existingProjectId = 1L;
        negativeProjectId = -1L;

        List<Document> documents = new ArrayList<>();
        documents.add(ProjectDocumentFactory.createDocument(1L,"Contrato", "Contrato de Prestação de Serviços", LocalDate.parse("2023-02-10"), "Um acordo formal entre o proprietário e a empresa de construção que estabelece os termos, condições e responsabilidades relacionadas à construção.", existingProjectId));

        Mockito.when(documentRepository.findByProjectId(existingProjectId)).thenReturn(documents);
        Mockito.when(documentRepository.findByProjectId(null)).thenThrow(InvalidProjectIdException.class);
        Mockito.when(documentRepository.findByProjectId(negativeProjectId)).thenThrow(InvalidProjectIdException.class);
    }

    @Test
    public void getProductDocumentShouldReturnDocumentDTO() {

        List<DocumentDTO> result = documentService.getProjectDocument(existingProjectId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Contrato", result.get(0).getDocumentType());
        Assertions.assertEquals("Contrato de Prestação de Serviços", result.get(0).getDocumentName());
    }

    @Test
    public void getProductDocumentShouldReturnInvalidProjectIdExceptionWhenIdIsNull() {

        Assertions.assertThrows(InvalidProjectIdException.class, () -> {
            documentService.getProjectDocument(null);
        });
    }

    @Test
    public void getProductDocumentShouldReturnInvalidProjectIdExceptionWhenIdIsNegative() {

        Assertions.assertThrows(InvalidProjectIdException.class, () -> {
            documentService.getProjectDocument(negativeProjectId);
        });
    }
}
