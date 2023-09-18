package com.ogficontrol.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_risk")
public class Risk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double probability;
    private Double impact;
    private Double realEstateRisk;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}