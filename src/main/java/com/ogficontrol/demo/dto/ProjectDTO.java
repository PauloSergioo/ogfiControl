package com.ogficontrol.demo.dto;

import com.ogficontrol.demo.entities.Project;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProjectDTO {

    private Long id;
    private String projectName;
    private String location;
    private Double budget;
    private LocalDate startDate;
    private LocalDate estimatedCompletionDate;
    private String description;
    private Double balance;
    private Double operatingCosts;

    public ProjectDTO() {
    }

    public ProjectDTO(Long id, String projectName, String location, Double budget, LocalDate startDate, LocalDate estimatedCompletionDate, String description, Double balance, Double operatingCosts) {
        this.id = id;
        this.projectName = projectName;
        this.location = location;
        this.budget = budget;
        this.startDate = startDate;
        this.estimatedCompletionDate = estimatedCompletionDate;
        this.description = description;
        this.balance = balance;
        this.operatingCosts = operatingCosts;
    }

    public ProjectDTO(Project entity) {
        id = entity.getId();
        projectName = entity.getProjectName();
        location = entity.getLocation();
        budget = entity.getBudget();
        startDate = entity.getStartDate();
        estimatedCompletionDate = entity.getEstimatedCompletionDate();
        description = entity.getDescription();
        balance = entity.getBalance();
        operatingCosts = entity.getOperatingCosts();
    }
}
