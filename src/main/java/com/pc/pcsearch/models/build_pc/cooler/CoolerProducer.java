package com.pc.pcsearch.models.build_pc.cooler;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "Cooler_producer")
public class CoolerProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
}
