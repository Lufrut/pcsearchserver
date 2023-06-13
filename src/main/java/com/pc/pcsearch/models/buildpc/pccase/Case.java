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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FormFactor> formFactor;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private  CasePowerSupplyLocation powerSupplyLocation;

    private Boolean fansIncluded;

    private int usb_3_2;

    private int usb_3_0;

    private int usb_2_0;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<CaseDesignFeatures> designFeatures;

    private int maxLengthOfGraphicCard;

    private String description;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private PerformanceLevel performanceLevel;
}
