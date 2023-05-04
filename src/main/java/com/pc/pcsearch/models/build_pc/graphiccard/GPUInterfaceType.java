package com.pc.pcsearch.models.build_pc.graphiccard;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "gpu_interface_type")
public class GPUInterfaceType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String interfaceType;

}
