package com.ogficontrol.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documentType;
    private String documentName;
    private LocalDate sentDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
