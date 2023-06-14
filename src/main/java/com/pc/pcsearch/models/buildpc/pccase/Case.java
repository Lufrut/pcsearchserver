package com.pc.pcsearch.models.buildpc.pccase;
import com.pc.pcsearch.models.buildpc.FormFactor;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.models.buildpc.Producers;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data

@Entity
@Table(name = "pc_case")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private Producers producer;

    @ManyToOne
    private CaseSize size;

    @ManyToMany
    @JoinTable(
            name = "pc_case_form_factor",
            joinColumns = @JoinColumn(name = "pc_case_id"),
            inverseJoinColumns = @JoinColumn(name = "form_factor_id"))
    private List<FormFactor> formFactor;

    @ManyToOne
    private  CasePowerSupplyLocation powerSupplyLocation;

    private Boolean fansIncluded;

    private int usb_3_2;

    private int usb_3_0;

    private int usb_2_0;

    @ManyToMany
    @JoinTable(
            name = "pc_case_Case_design_features",
            joinColumns = @JoinColumn(name = "pc_case_id"),
            inverseJoinColumns = @JoinColumn(name = "Case_design_features_id"))
    private List<CaseDesignFeatures> designFeatures;

    private int maxLengthOfGraphicCard;

    private String description;

    private int recommendedPrice;

    @ManyToOne
    private PerformanceLevel performanceLevel;
}
