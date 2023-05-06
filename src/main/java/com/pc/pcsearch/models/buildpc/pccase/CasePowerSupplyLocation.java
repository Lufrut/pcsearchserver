package com.pc.pcsearch.models.buildpc.pccase;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "Case_power_supply_location")
public class CasePowerSupplyLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "power_supply_location")
    private String powerSupplyLocation;
}
