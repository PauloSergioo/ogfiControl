package com.ogficontrol.demo.tests;

import com.ogficontrol.demo.entities.Cost;
import com.ogficontrol.demo.entities.Project;
import com.ogficontrol.demo.entities.Risk;

import java.time.LocalDate;

public class ProjectRiskFactory {

    public static Risk createRisk(Long id, String description, Double probability, Double impact, Double realEstateRisk, Long projectId) {
        Risk cost = new Risk();
        Project project = new Project();
        cost.setId(id);
        cost.setDescription(description);
        cost.setProbability(probability);
        cost.setImpact(impact);
        cost.setRealEstateRisk(realEstateRisk);
        cost.setProject(project);
        return cost;
    }
}