package com.ogficontrol.demo.services;

import com.ogficontrol.demo.dto.CostDTO;
import com.ogficontrol.demo.entities.Cost;
import com.ogficontrol.demo.repositories.CostRepository;
import com.ogficontrol.demo.repositories.ProjectRepository;
import com.ogficontrol.demo.services.exceptions.InvalidProjectIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectCostService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CostRepository costRepository;

    public List<CostDTO> getProjectCosts(Long projectId) {
        if (projectId == null || projectId < 1) {
            throw new InvalidProjectIdException("ID do projeto inválido: " + projectId);
        }
        List<Cost> costs = costRepository.findByProjectId(projectId);
        return costs.stream().map(CostDTO::new).collect(Collectors.toList());
    }
}
