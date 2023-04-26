package com.pc.pcsearch.models.build_pc.ram;
import com.pc.pcsearch.models.build_pc.PerfomanceLevel;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "ram")
public class Ram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int producer;

    private int memoryType;

    private int memoryCapacity;

    private int frequency;

    private int timings;

    private float powerSupplyVoltage;

    private String description;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PerfomanceLevel perfomanceLevel;
}
