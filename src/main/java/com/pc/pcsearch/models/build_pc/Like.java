package com.pc.pcsearch.models.build_pc;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private BuildPc buildPc;

    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

}
