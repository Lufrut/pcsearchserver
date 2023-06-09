package com.pc.pcsearch.models.buildpc.pccase;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "Case_design_features")
public class CaseDesignFeatures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "design_features")
    private String designFeatures;
}
