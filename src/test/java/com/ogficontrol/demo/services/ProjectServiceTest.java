package com.ogficontrol.demo.services;

import com.ogficontrol.demo.dto.ProjectDTO;
import com.ogficontrol.demo.entities.Project;
import com.ogficontrol.demo.repositories.ProjectRepository;
import com.ogficontrol.demo.services.exceptions.DatabaseException;
import com.ogficontrol.demo.services.exceptions.ResourceNotFoundException;
import com.ogficontrol.demo.tests.ProjectFactory;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class ProjectServiceTest {

    @InjectMocks
    private ProjectService service;

    @Mock
    private ProjectRepository repository;

    private long existingProjectId;
    private long nonExistingProjectId;

    private Long  dependentProjectId;
    private String projectName;
    private Project project;
    private ProjectDTO projectDTO;

    @BeforeEach
    void setUp() throws Exception {

        existingProjectId = 1L;
        nonExistingProjectId = 2L;
        dependentProjectId = 3L;
        projectName = "PlayStation 5";

        project = ProjectFactory.createProject(projectName);
        projectDTO = new ProjectDTO(project);
        PageImpl<Project> page = new PageImpl<>(List.of(project));

        Mockito.when(repository.findById(existingProjectId)).thenReturn(Optional.of(project));
        Mockito.when(repository.findById(nonExistingProjectId)).thenReturn(Optional.empty());

        Mockito.when(repository.findAllByProjectName(any(), (Pageable)any())).thenReturn(page);

        Mockito.when(repository.save(any())).thenReturn(project);

        Mockito.when(repository.getReferenceById(existingProjectId)).thenReturn(project);
        Mockito.when(repository.getReferenceById(nonExistingProjectId)).thenThrow(EntityNotFoundException.class);

        Mockito.when(repository.existsById(existingProjectId)).thenReturn(true);
        Mockito.when(repository.existsById(dependentProjectId)).thenReturn(true);
        Mockito.when(repository.existsById(nonExistingProjectId)).thenReturn(false);

        Mockito.doNothing().when(repository).deleteById(existingProjectId);
        Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(dependentProjectId);
    }

    @Test
    public void findByIdShouldReturnProjectDTOWhenIdExists() {

        ProjectDTO result = service.findById(existingProjectId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), existingProjectId);
        Assertions.assertEquals(result.getProjectName(), project.getProjectName());
    }

    @Test
    public void findByIdShouldReturnResourceNotFoundExceptionWhenIdDoesNotExist() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(nonExistingProjectId);
        });
    }

    @Test
    public void findAllShouldReturnPagedProjectMinDTO() {
        Pageable pageable = PageRequest.of(0, 12);
        Page<ProjectDTO> result = service.findAll(projectName, pageable);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getSize(), 1);
        Assertions.assertEquals(result.iterator().next().getProjectName(), projectName);
    }

    @Test
    public void insertShouldReturnProjectDTO() {

        ProjectDTO result = service.insert(projectDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), project.getId());
    }

    @Test
    public void updateShouldReturnProjectDTOWhenIdExists() {
        ProjectDTO result = service.update(existingProjectId, projectDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), existingProjectId);
        Assertions.assertEquals(result.getProjectName(), projectDTO.getProjectName());
    }

    @Test
    public void updateShouldReturnResourceNotFoundExceptionWhenIdDoesNotExists() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.update(nonExistingProjectId, projectDTO);
        });
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.delete(existingProjectId);
        });
    }

    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.delete(nonExistingProjectId);
        });
    }

    @Test
    public void deleteShouldThrowDatabaseExceptionWhenIdDoesNotExists() {
        Assertions.assertThrows(DatabaseException.class, () -> {
            service.delete(dependentProjectId);
        });
    }
}