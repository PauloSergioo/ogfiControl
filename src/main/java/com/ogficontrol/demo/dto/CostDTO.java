package com.ogficontrol.demo.dto;

import com.ogficontrol.demo.entities.Cost;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CostDTO {

    private Long id;
    private String description;
    private Double amount;
    private LocalDate date;

    public CostDTO() {
    }

    public CostDTO(Long id, String description, Double amount, LocalDate date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public CostDTO(Cost entity) {
        id = entity.getId();
        description = entity.getDescription();
        amount = entity.getAmount();
        date = entity.getDate();
    }
}
