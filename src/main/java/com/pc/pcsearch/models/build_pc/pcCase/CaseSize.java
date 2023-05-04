package com.pc.pcsearch.models.build_pc.pcCase;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "Case_Producer")
public class CaseSize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "size")
    private String size;
}
