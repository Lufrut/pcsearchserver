package com.pc.pcsearch.models.build_pc.graphiccard;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "gpu_producer")
public class GPUProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String producer;
}
