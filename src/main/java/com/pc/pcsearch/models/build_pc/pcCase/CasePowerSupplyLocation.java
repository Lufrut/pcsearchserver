package com.pc.pcsearch.models.build_pc.pcCase;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "Case_power_supply_location")
public class CasePowerSupplyLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "power_supply_location")
    private String powerSupplyLocation;
}