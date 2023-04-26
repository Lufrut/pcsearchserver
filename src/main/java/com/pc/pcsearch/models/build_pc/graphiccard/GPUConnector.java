package com.pc.pcsearch.models.build_pc.graphiccard;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "gpu_connector")
public class GPUConnector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String connector;
}
