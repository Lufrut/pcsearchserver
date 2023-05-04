package com.pc.pcsearch.models.build_pc.powerSupply;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "power_supply_protection_functions")
public class PowerSupplyProtectionFunctions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
}
