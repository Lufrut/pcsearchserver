package com.pc.pcsearch.models.buildpc.pcCase;
import com.pc.pcsearch.models.buildpc.FormFactor;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Data

@Entity
@Table(name = "pccase")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CaseProducer producer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CaseSize size;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ArrayList<FormFactor> formFactor;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private  CasePowerSupplyLocation powerSupplyLocation;

    private Boolean fansIncluded;

    private int usb_3_2;

    private int usb_3_0;

    private int usb_2_0;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private ArrayList<CaseDesignFeatures> designFeatures;

    private int maxLengthOfGraphicCard;

    private int powerSupplyFormFactor;

    private String description;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private PerformanceLevel performanceLevel;
}