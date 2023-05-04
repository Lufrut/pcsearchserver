package com.pc.pcsearch.models.buildpc.graphiccard;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "gpu_vendor")
public class GPUVendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String vendor;
}
