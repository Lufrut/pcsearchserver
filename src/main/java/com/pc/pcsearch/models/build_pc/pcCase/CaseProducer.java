package com.pc.pcsearch.models.build_pc.pcCase;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "Case_Producer")
public class CaseProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "producer")
    private String producer;
}
