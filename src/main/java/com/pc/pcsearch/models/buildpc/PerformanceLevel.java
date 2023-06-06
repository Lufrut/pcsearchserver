package com.pc.pcsearch.models.buildpc;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "performance_level")
public class PerformanceLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String level;
}
