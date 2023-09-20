package com.ogficontrol.demo.dto;

import com.ogficontrol.demo.entities.Document;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DocumentDTO {

    private Long id;
    private String documentType;
    private String documentName;
    private LocalDate sentDate;
    private String description;

    public DocumentDTO() {
    }

    public DocumentDTO(Long id, String documentType, String documentName, LocalDate sentDate, String description) {
        this.id = id;
        this.documentType = documentType;
        this.documentName = documentName;
        this.sentDate = sentDate;
        this.description = description;
    }

    public DocumentDTO(Document entity) {
        id = entity.getId();
        documentType = entity.getDocumentType();
        documentName = entity.getDocumentName();
        sentDate = entity.getSentDate();
        description = entity.getDescription();
    }
}
