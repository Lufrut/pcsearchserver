package com.pc.pcsearch.models.buildpc.powerSupply;
import com.pc.pcsearch.models.buildpc.FormFactor;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data

@Entity
@Table(name = "power_supply")
public class PowerSupply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private PowerSupply producer;

    private String name;

    private int power;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private FormFactor formFactor;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private PerformanceLevel performanceLevel;

    private boolean pfcModule;

    private boolean modularConnection;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<PowerSupplyProtectionFunctions> protection;

    private int cpu_4pin;

    private int cpu_4plus4pin;

    private int cpu_8pin;

    private int pcie_6plus2pin;

    private int pcie_8pin;

    private int pcie_5_16pin;

    private int sata;

    private int count_of_12_v_lines;

    private String description;

    private int recommendedPrice;

}
