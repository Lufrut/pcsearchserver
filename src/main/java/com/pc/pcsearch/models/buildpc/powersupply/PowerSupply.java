package com.pc.pcsearch.models.buildpc.powersupply;
import com.pc.pcsearch.models.buildpc.FormFactor;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.models.buildpc.Producers;
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

    @ManyToOne
    private Producers producer;

    private String name;

    private int power;

    @ManyToOne
    private FormFactor formFactor;

    @ManyToOne
    private PerformanceLevel performanceLevel;

    private boolean pfcModule;

    private boolean modularConnection;

    @ManyToMany
    @JoinTable(
            name = "power_supply_power_supply_protection_functions",
            joinColumns = @JoinColumn(name = "power_supply_id"),
            inverseJoinColumns = @JoinColumn(name = "power_supply_protection_functions_id"))
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
