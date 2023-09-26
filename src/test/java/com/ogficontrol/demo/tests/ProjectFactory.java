package com.ogficontrol.demo.tests;

import com.ogficontrol.demo.entities.Project;

import java.time.LocalDate;

public class ProjectFactory {

    public static Project createProject() {
        Project project = new Project();
        project.setId(1L);
        project.setProjectName("Edifício Montanha Verde");
        project.setLocation("São Paulo");
        project.setBudget(100000.00);
        project.setStartDate(LocalDate.parse("2023-01-01"));
        project.setEstimatedCompletionDate(LocalDate.parse("2023-12-31"));
        project.setDescription("Próximo a trilhas para caminhadas e esportes ao ar livre.");
        project.setBalance(50000.00);
        project.setOperatingCosts(25000.00);
        return project;
    }


    public static Project createProject(String name) {
        Project product = createProject();
        product.setProjectName(name);
        return product;
    }
}