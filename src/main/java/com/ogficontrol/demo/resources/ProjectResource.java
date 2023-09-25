package com.ogficontrol.demo.resources;

import com.ogficontrol.demo.dto.ProjectDTO;
import com.ogficontrol.demo.services.ProjectService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/projects")
@Tag(name = "Projects", description = "Controller for Projects")
public class ProjectResource {

    @Autowired
    private ProjectService service;

    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<ProjectDTO>> findAll(
            @RequestParam(value = "projectName", defaultValue = "") String projectName,
            Pageable pageable) {
        Page<ProjectDTO> list = service.findAll(projectName, pageable);
        return ResponseEntity.ok().body(list);
    }

    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ProjectDTO> findById(@PathVariable Long id) {
        ProjectDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(produces = "application/json")
    public ResponseEntity<ProjectDTO> insert(@Valid @RequestBody ProjectDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ProjectDTO> update(@PathVariable Long id, @Valid @RequestBody ProjectDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
