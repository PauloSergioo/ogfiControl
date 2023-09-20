package com.ogficontrol.demo.resources;

import com.ogficontrol.demo.dto.CostDTO;
import com.ogficontrol.demo.services.ProjectCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectCostResource {

    @Autowired
    private ProjectCostService costService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}/costs")
    public ResponseEntity<List<CostDTO>> getCostsByProjectId(@PathVariable Long id) {
        List<CostDTO> costs = costService.getProjectCosts(id);
        return ResponseEntity.ok(costs);
    }
}
