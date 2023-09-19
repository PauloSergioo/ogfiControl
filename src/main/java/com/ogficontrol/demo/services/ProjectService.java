package com.ogficontrol.demo.services;

import com.ogficontrol.demo.dto.ProjectDTO;
import com.ogficontrol.demo.entities.Project;
import com.ogficontrol.demo.repositories.ProjectRepository;
import com.ogficontrol.demo.services.exceptions.DatabaseException;
import com.ogficontrol.demo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {


    @Autowired
    private ProjectRepository repository;

    public Page<ProjectDTO> findAll(String projectName, Pageable pageable) {
        Page<Project> list = repository.findAllByProjectName(projectName, pageable);
        return list.map(ProjectDTO::new);
    }

    public ProjectDTO findById(Long id) {
        Optional<Project> obj = repository.findById(id);
        Project entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ProjectDTO(entity);
    }

    public ProjectDTO insert(ProjectDTO dto) {
        Project entity = new Project();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProjectDTO(entity);
    }

    public ProjectDTO update(Long id, ProjectDTO dto) {
        try {
            Optional<Project> optionalEntity = repository.findById(id);
            if (optionalEntity.isEmpty()) {
                throw new ResourceNotFoundException("Id not found " + id);
            }
            Project entity = optionalEntity.get();
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ProjectDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ProjectDTO dto, Project entity) {

        entity.setProjectName(dto.getProjectName());
        entity.setLocation(dto.getLocation());
        entity.setBudget(dto.getBudget());
        entity.setStartDate(dto.getStartDate());
        entity.setEstimatedCompletionDate(dto.getEstimatedCompletionDate());
        entity.setDescription(dto.getDescription());
        entity.setBalance(dto.getBalance());
        entity.setOperatingCosts(dto.getOperatingCosts());
    }
}