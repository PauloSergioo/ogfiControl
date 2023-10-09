package com.ogficontrol.demo.services;

import com.ogficontrol.demo.dto.RiskDTO;
import com.ogficontrol.demo.entities.Risk;
import com.ogficontrol.demo.repositories.ProjectRepository;
import com.ogficontrol.demo.repositories.RiskRepository;
import com.ogficontrol.demo.services.exceptions.InvalidProjectIdException;
import com.ogficontrol.demo.services.validation.ProjectIdValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectRiskService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RiskRepository riskRepository;

    public List<RiskDTO> getProjectRisks(Long projectId) {
        ProjectIdValidation.validateProjectId(projectId);
        List<Risk> risks = riskRepository.findByProjectId(projectId);
        ProjectIdValidation.validateNonEmptyList(risks, "Empty risks list for project: " + projectId);
        return risks.stream().map(RiskDTO::new).collect(Collectors.toList());
    }
}
