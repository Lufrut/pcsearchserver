package com.pc.pcsearch.models.buildpc.pcCase;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "Case_Producer")
public class CaseProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "producer")
    private String producer;
}
