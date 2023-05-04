package com.pc.pcsearch.models.buildpc.processor;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "cpu_producer")
public class CPUProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;


}
