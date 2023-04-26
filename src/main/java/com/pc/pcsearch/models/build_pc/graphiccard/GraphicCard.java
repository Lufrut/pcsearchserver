package com.pc.pcsearch.models.build_pc.graphiccard;
import com.pc.pcsearch.models.build_pc.PerfomanceLevel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data

@Entity
@Table(name = "graphic_card")
public class GraphicCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private GPUProducer producer;

    private  String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private GPUVendor vendor;

    private int year;

    private int technicalProcess;

    private int gpuFrequency;

    private int memoryAmount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private GPUMemoryType memoryType;

    private int memoryFrequency;

    private int bus;

    private int tdp;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GPUConnector> connector;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private GPUInterfaceType interfaceType;

    private int length;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GraphicCardGPUTechnologies> gpuTechnologies;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PerfomanceLevel perfomanceLevel;
}
