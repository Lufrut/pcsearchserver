package com.pc.pcsearch.models.buildpc.powersupply;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "power_supply_producer")
public class PowerSupplyProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String producer;

}
