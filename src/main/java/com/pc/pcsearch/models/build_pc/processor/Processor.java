package com.pc.pcsearch.models.build_pc.processor;
import com.pc.pcsearch.models.build_pc.motherboard.MotherboardSocket;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "processor")
public class Processor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CPUProducer producer;

    private int yearOfRelease;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MotherboardSocket socket;

    private int countOfCores;

    private int countOfThreads;

    private int baseFrequency;

    private int turboFrequency;

    private int l3Cache;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private CPUGeneration cpuGeneration;

    private int technicalProcess;

    private int tdp;

    private int maxTemperature;

    private Boolean embeddedGraphic;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private CPUPcieVersion pcieVersion;

    private String description;
}
