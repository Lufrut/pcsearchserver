package com.pc.pcsearch.models.build_pc.ram;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "ram_producer")
public class RamProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String producer;
}
