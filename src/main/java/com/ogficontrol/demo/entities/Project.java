package com.ogficontrol.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String location;
    private Double budget;
    private LocalDate startDate;
    private LocalDate estimatedCompletionDate;
    private String description;
    private Double balance;
    private Double operatingCosts;

    @ManyToMany(mappedBy = "projects")
    private List<User> users;

    @OneToMany(mappedBy = "project")
    private List<Cost> costs;

    @OneToMany(mappedBy = "project")
    private List<Risk> risks;

    @OneToMany(mappedBy = "project")
    private List<Document> documents;
}