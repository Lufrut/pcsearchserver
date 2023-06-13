package com.pc.pcsearch.models.buildpc.cooler;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.models.buildpc.Producers;
import com.pc.pcsearch.models.buildpc.motherboard.MotherboardSocket;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data

@Entity
@Table(name = "Cooler")
public class Cooler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private Producers producer;

    @OneToMany
    private List<MotherboardSocket> socket;

    @ManyToOne
    private CoolerMaterial material;

    private int maxTdp;

    private int thermalTubes;

    private String description;

    private int recommendedPrice;

    @ManyToOne
    private PerformanceLevel performanceLevel;
}
