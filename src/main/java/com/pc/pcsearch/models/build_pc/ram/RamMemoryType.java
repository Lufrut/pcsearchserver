package com.pc.pcsearch.models.build_pc.ram;

import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "ram_memory_type")
public class RamMemoryType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String memoryType;
}
