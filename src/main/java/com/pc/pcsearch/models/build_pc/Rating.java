package com.pc.pcsearch.models.build_pc;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "build_pc")
    private List<Like> like;

    @ManyToOne(cascade = CascadeType.MERGE)
    private BuildPc buildPc;
}
