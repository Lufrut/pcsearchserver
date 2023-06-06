package com.pc.pcsearch.models.buildpc.processor;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.models.buildpc.Producers;
import com.pc.pcsearch.models.buildpc.motherboard.MotherboardSocket;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data

@Entity
@Table(name = "processor")
public class Processor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="producer_id")
    private Producers producer;

    private int yearOfRelease;


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="socket_id")
    private MotherboardSocket socket;

    private int countOfCores;

    private int countOfThreads;

    private int baseFrequency;

    private int turboFrequency;

    private int l3Cache;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="cpu_generation_id")
    private CPUGeneration cpuGeneration;

    private int technicalProcess;

    private int tdp;

    private int maxTemperature;

    private Boolean embeddedGraphic;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="pcie_version_id")
    private CPUPcieVersion pcieVersion;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "processor_cpu_tech",
            joinColumns = @JoinColumn(name = "processor_id"),
            inverseJoinColumns = @JoinColumn(name = "cpu_tech_id"))
    private List<CPUTech> cpuTech;

    private String description;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="performance_level_id")
    private PerformanceLevel performanceLevel;
}
