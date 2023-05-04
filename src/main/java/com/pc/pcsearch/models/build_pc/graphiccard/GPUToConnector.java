package com.pc.pcsearch.models.build_pc.graphiccard;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "gpu_to_connector")
public class GPUToConnector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private GraphicCard graphicCard;

    @ManyToOne(cascade = CascadeType.MERGE)
    private GPUConnector gpuConnector;

    private int count;
}
