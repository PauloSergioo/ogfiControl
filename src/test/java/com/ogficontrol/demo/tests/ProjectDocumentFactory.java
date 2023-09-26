package com.ogficontrol.demo.tests;

import com.ogficontrol.demo.entities.Document;
import com.ogficontrol.demo.entities.Project;

import java.time.LocalDate;

public class ProjectDocumentFactory {

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

