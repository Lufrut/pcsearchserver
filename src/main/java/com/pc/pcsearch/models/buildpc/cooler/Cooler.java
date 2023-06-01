package com.pc.pcsearch.models.buildpc.cooler;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.models.buildpc.Producers;
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

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Producers producer;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<CoolerSocket> socket;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private CoolerMaterial material;

    private int maxTdp;

    private int thermalTubes;

    private String description;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private PerformanceLevel performanceLevel;
}
