package com.pc.pcsearch.models.build_pc.graphiccard;
import com.pc.pcsearch.models.build_pc.PerformanceLevel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data

@Entity
@Table(name = "graphic_card")
public class GraphicCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private GPUProducer producer;

    private  String name;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private GPUVendor vendor;

    private int year;

    private int technicalProcess;

    private int gpuFrequency;

    private int memoryAmount;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private GPUMemoryType memoryType;

    private int memoryFrequency;

    private int bus;

    private int tdp;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<GPUConnector> connector;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private GPUInterfaceType interfaceType;

    private int length;

    private String description;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private GPUTechnologies gpuTechnologies;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private PerformanceLevel performanceLevel;
}
