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

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private BuildPC buildPc;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private User user;

}
