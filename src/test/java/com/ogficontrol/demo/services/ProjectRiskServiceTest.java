package com.ogficontrol.demo.services;

import com.ogficontrol.demo.repositories.ProjectRepository;
import com.ogficontrol.demo.repositories.RiskRepository;
import com.ogficontrol.demo.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProjectRiskServiceTest {

    @InjectMocks
    private ProjectService service;

    @Mock
    private ProjectRepository repository;

    @Mock
    private RiskRepository riskRepository;

    private long existingProjectId;
    private long nonExistingProjectId;

    @BeforeEach
    void setUp() {

        existingProjectId = 1L;
        nonExistingProjectId = 2L;
    }

    @Test
    public void getProductRiskShouldReturnRiskDTO() {
    }
}
