package com.pc.pcsearch.models.build_pc.graphiccard;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data

@Entity
@Table(name = "graphic_card_gpu_technologies")
public class GraphicCardGPUTechnologies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private GraphicCard graphicCard;

    @ManyToOne(cascade = CascadeType.MERGE)
    private GPUTechnologies gpuTechnologies;

    private int count;
}
