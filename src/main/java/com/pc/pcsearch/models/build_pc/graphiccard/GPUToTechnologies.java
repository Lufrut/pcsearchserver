package com.pc.pcsearch.models.build_pc.graphiccard;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "gpu_to_technologies")
public class GPUToTechnologies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private GraphicCard graphicCard;

    @ManyToOne(cascade = CascadeType.MERGE)
    private GPUTechnologies gpuTechnologies;

    private int count;
}
