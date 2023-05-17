package com.pc.pcsearch.models.buildpc.ram;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.models.buildpc.Producers;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "ram")
public class Ram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Producers producer;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private RamMemoryType memoryType;

    private int memoryCapacity;

    private int frequency;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private RamTimings timings;

    private float powerSupplyVoltage;

    private String description;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private PerformanceLevel performanceLevel;
}
