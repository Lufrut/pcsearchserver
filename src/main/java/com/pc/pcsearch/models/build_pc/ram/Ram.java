package com.pc.pcsearch.models.build_pc.ram;
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
}
