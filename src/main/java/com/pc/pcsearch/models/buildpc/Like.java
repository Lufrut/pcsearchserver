package com.pc.pcsearch.models.buildpc;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private BuildPC buildPc;

    @ManyToOne
    private User user;

}
