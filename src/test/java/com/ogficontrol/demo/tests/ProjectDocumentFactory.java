package com.ogficontrol.demo.tests;

import com.ogficontrol.demo.entities.Document;
import com.ogficontrol.demo.entities.Project;

import java.time.LocalDate;

public class ProjectDocumentFactory {

//    public static Document createProjectDocument() {
//        Document document = new Document();
//        document.setId(1L);
//        document.setDocumentType("Contrato");
//        document.setDocumentName("Contrato de Prestação de Serviços");
//        document.setSentDate(LocalDate.parse("2023-02-10"));
//        document.setDescription("Próximo a trilhas para caminhadas e esportes ao ar livre.");
//        return document;
//    }

    public static Document createDocument(Long id, String documentType, String documentName, LocalDate sentDate, String description, Long projectId) {
        Document document = new Document();
        Project project = new Project();
        document.setId(id);
        document.setDocumentType(documentType);
        document.setDocumentName(documentName);
        document.setSentDate(sentDate);
        document.setDescription(description);
        document.setProject(project);
        return document;
    }
}

