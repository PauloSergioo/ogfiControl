package com.ogficontrol.demo.dto;

import com.ogficontrol.demo.entities.Risk;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RiskDTO {

    private Long id;
    private String description;
    private Double probability;
    private Double impact;
    private Double realEstateRisk;

    public RiskDTO() {
    }

    public RiskDTO(Long id, String description, Double probability, Double impact, Double realEstateRisk) {
        this.id = id;
        this.description = description;
        this.probability = probability;
        this.impact = impact;
        this.realEstateRisk = realEstateRisk;
    }

    public RiskDTO(Risk entity) {
        id = entity.getId();
        description = entity.getDescription();
        probability = entity.getProbability();
        impact = entity.getImpact();
        realEstateRisk = entity.getRealEstateRisk();
    }
}
