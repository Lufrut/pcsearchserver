package com.pc.pcsearch.models.build_pc.processor;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "cpu_tech")
public class CPUTech {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
}
