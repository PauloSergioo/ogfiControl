package com.ogficontrol.demo.dto;

import com.ogficontrol.demo.entities.Project;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ProjectDTO {

    private Long id;

    @Size(min = 8, message = "Deve ter no mínimo 8 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String projectName;

    @Size(min = 8, message = "Deve ter no mínimo 8 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String location;

    @Positive(message = "O valor deve ser um número positivo")
    private Double budget;

    @FutureOrPresent(message = "A data de início deve ser no futuro ou no presente")
    private LocalDate startDate;

    @Future(message = "A data deve ser uma data futura")
    private LocalDate estimatedCompletionDate;

    @Size(min = 20, message = "Deve ter no mínimo 20 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String description;

    @Positive(message = "O valor deve ser um número positivo")
    private Double balance;

    @Positive(message = "O valor deve ser um número positivo")
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