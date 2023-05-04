package com.pc.pcsearch.models.build_pc;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "perfomance_level")
public class PerformanceLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String level;
}
