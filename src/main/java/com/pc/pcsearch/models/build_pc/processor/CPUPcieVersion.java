package com.pc.pcsearch.models.build_pc.processor;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "cpu_pcie_version")
public class CPUPcieVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
}
