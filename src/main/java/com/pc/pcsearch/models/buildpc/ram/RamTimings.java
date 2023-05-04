package com.pc.pcsearch.models.buildpc.ram;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "ram_timings")
public class RamTimings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String timings;
}