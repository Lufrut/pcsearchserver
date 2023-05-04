package com.pc.pcsearch.models.buildpc.ram;

import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "ram_memory_type")
public class RamMemoryType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String memoryType;
}
