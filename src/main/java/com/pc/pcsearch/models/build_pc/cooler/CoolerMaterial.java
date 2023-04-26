package com.pc.pcsearch.models.build_pc.cooler;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "Cooler_material")
public class CoolerMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String material;
}
