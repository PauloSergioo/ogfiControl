package com.ogficontrol.demo.services;

import com.ogficontrol.demo.dto.CostDTO;
import com.ogficontrol.demo.dto.DocumentDTO;
import com.ogficontrol.demo.entities.Cost;
import com.ogficontrol.demo.repositories.CostRepository;
import com.ogficontrol.demo.repositories.ProjectRepository;
import com.ogficontrol.demo.services.exceptions.InvalidProjectIdException;
import com.ogficontrol.demo.tests.ProjectCostFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class ProjectCostServiceTest {

    @InjectMocks
    private ProjectService service;

    @InjectMocks
    private ProjectCostService costService;

    @Mock
    private ProjectRepository repository;

    @Mock
    private CostRepository costRepository;

    private long existingProjectId;
    private long negativeProjectId;

    @BeforeEach
    void setUp() {

        existingProjectId = 1L;
        negativeProjectId = -1L;

        List<Cost> costs = new ArrayList<>();
        costs.add(ProjectCostFactory.createCost(1L,"Custo de Mão de Obra", 7000.00, LocalDate.parse("2023-04-20"), existingProjectId));

        Mockito.when(costRepository.findByProjectId(existingProjectId)).thenReturn(costs);
        Mockito.when(costRepository.findByProjectId(null)).thenThrow(InvalidProjectIdException.class);
        Mockito.when(costRepository.findByProjectId(negativeProjectId)).thenThrow(InvalidProjectIdException.class);
    }

    @Test
    public void getProductCostShouldReturnDocumentDTO() {

        List<CostDTO> result = costService.getProjectCosts(existingProjectId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Custo de Mão de Obra", result.get(0).getDescription());
        Assertions.assertEquals(7000.00, result.get(0).getAmount());
    }

    @Test
    public void getProductCostShouldReturnInvalidProjectIdExceptionWhenIdIsNull() {

        Assertions.assertThrows(InvalidProjectIdException.class, () -> {
            costService.getProjectCosts(null);
        });
    }

    @Test
    public void getProductCostShouldReturnInvalidProjectIdExceptionWhenIdIsNegative() {

        Assertions.assertThrows(InvalidProjectIdException.class, () -> {
            costService.getProjectCosts(negativeProjectId);
        });
    }
}
