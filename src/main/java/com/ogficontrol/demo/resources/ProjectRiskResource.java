package com.ogficontrol.demo.resources;

import com.ogficontrol.demo.dto.RiskDTO;
import com.ogficontrol.demo.services.ProjectRiskService;
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
public class ProjectRiskResource {

    @Autowired
    private ProjectRiskService riskService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}/risks")
    public ResponseEntity<List<RiskDTO>> getRisksByProjectId(@PathVariable Long id) {
        List<RiskDTO> risks = riskService.getProjectRisks(id);
        return ResponseEntity.ok(risks);
    }
}
