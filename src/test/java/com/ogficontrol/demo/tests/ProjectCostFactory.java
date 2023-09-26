package com.ogficontrol.demo.tests;

import com.ogficontrol.demo.entities.Cost;
import com.ogficontrol.demo.entities.Document;
import com.ogficontrol.demo.entities.Project;

import java.time.LocalDate;

public class ProjectCostFactory {

    public static Cost createCost(Long id, String description, Double amount, LocalDate date, Long projectId) {
        Cost cost = new Cost();
        Project project = new Project();
        cost.setId(id);
        cost.setDescription(description);
        cost.setAmount(amount);
        cost.setDate(date);
        cost.setProject(project);
        return cost;
    }
}