package com.pc.pcsearch.models.build_pc.cooler;
import com.pc.pcsearch.models.build_pc.PerfomanceLevel;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "Cooler")
public class Cooler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CoolerProducer producer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CoolerSocket socket;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CoolerMaterial material;

    private int maxTdp;

    private int thermalTubes;

    private String description;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PerfomanceLevel perfomanceLevel;
}
