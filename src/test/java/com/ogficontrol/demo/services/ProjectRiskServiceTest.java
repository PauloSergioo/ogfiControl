package com.ogficontrol.demo.services;

import com.ogficontrol.demo.dto.CostDTO;
import com.ogficontrol.demo.dto.RiskDTO;
import com.ogficontrol.demo.entities.Cost;
import com.ogficontrol.demo.entities.Risk;
import com.ogficontrol.demo.repositories.ProjectRepository;
import com.ogficontrol.demo.repositories.RiskRepository;
import com.ogficontrol.demo.services.exceptions.InvalidProjectIdException;
import com.ogficontrol.demo.services.exceptions.ResourceNotFoundException;
import com.ogficontrol.demo.tests.ProjectCostFactory;
import com.ogficontrol.demo.tests.ProjectRiskFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class ProjectRiskServiceTest {

    @InjectMocks
    private ProjectService service;

    @InjectMocks
    private ProjectRiskService riskService;

    @Mock
    private ProjectRepository repository;

    @Mock
    private RiskRepository riskRepository;

    private long existingProjectId;
    private long negativeProjectId;

    @BeforeEach
    void setUp() {

        existingProjectId = 1L;
        negativeProjectId = -1L;

        List<Risk> risks = new ArrayList<>();
        risks.add(ProjectRiskFactory.createRisk(1L, "Problemas geotécnicos nas montanhas podem comprometer a estabilidade do edifício.", 0.2, 0.4, 0.1, existingProjectId));

        Mockito.when(riskRepository.findByProjectId(existingProjectId)).thenReturn(risks);
        Mockito.when(riskRepository.findByProjectId(null)).thenThrow(InvalidProjectIdException.class);
        Mockito.when(riskRepository.findByProjectId(negativeProjectId)).thenThrow(InvalidProjectIdException.class);
    }

    @Test
    public void getProductCostShouldReturnDocumentDTO() {

        List<RiskDTO> result = riskService.getProjectRisks(existingProjectId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Problemas geotécnicos nas montanhas podem comprometer a estabilidade do edifício.", result.get(0).getDescription());
        Assertions.assertEquals(0.2, result.get(0).getProbability());
        Assertions.assertEquals(0.4, result.get(0).getImpact());
    }

    @Test
    public void getProductCostShouldReturnInvalidProjectIdExceptionWhenIdIsNull() {

        Assertions.assertThrows(InvalidProjectIdException.class, () -> {
            riskService.getProjectRisks(null);
        });
    }

    @Test
    public void getProductCostShouldReturnInvalidProjectIdExceptionWhenIdIsNegative() {

        Assertions.assertThrows(InvalidProjectIdException.class, () -> {
            riskService.getProjectRisks(negativeProjectId);
        });
    }
}
