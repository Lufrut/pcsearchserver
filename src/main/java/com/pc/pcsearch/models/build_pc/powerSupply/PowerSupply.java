package com.pc.pcsearch.models.build_pc.powerSupply;
import com.pc.pcsearch.models.build_pc.FormFactor;
import com.pc.pcsearch.models.build_pc.PerfomanceLevel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data

@Entity
@Table(name = "power_supply")
public class PowerSupply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int producer;

    private String name;

    private int power;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private FormFactor formFactor;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PerfomanceLevel performanceLevel;

    private boolean pfcModule;

    private boolean modularConnection;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PowerSupplyProtectionFunctions> protection;

    private int cpu_4pin;

    private int cpu_4plus4pin;

    private int cpu_8pin;

    private int pcie_6plus2pin;

    private int pcie_8pin;

    private int pcie_5_16pin;

    private int sata;

    private int count_of_12_v_lines;

    private int description;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PerfomanceLevel perfomanceLevel;

}
