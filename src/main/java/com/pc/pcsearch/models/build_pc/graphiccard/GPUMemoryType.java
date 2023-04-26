package com.pc.pcsearch.models.build_pc.graphiccard;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "gpu_memory_type")
public class GPUMemoryType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String type;
}
