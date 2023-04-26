package com.pc.pcsearch.models.build_pc;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "perfomance_level")
public class PerfomanceLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String level;
}
