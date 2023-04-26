package com.pc.pcsearch.models.build_pc.ram;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "ram_timings")
public class RamTimings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String timings;
}