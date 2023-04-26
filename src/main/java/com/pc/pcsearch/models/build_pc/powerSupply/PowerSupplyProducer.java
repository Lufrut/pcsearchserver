package com.pc.pcsearch.models.build_pc.powerSupply;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Data

@Entity
@Table(name = "power_supply_producer")
public class PowerSupplyProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String producer;

}
