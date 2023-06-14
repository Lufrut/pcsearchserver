package com.pc.pcsearch.models.buildpc.graphiccard;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.models.buildpc.Producers;
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

    @ManyToOne
    private Producers producer;

    private  String name;

    @ManyToOne
    private Producers vendor;

    private int year;

    private int technicalProcess;

    private int gpuFrequency;

    private int memoryAmount;

    @ManyToOne
    private GPUMemoryType memoryType;

    private int memoryFrequency;

    private int bus;

    private int tdp;

    @ManyToMany
    @JoinTable(
            name = "graphic_card_gpu_connector",
            joinColumns = @JoinColumn(name = "graphic_card_id"),
            inverseJoinColumns = @JoinColumn(name = "gpu_connector_id"))
    private List<GPUConnector> connector;

    @ManyToOne
    private GPUInterfaceType interfaceType;

    private int length;

    private String description;
    @ManyToOne
    private GPUTechnologies gpuTechnologies;

    private int recommendedPrice;

    @ManyToOne
    private PerformanceLevel performanceLevel;
}
