package com.pc.pcsearch.models.buildpc;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Like> like;

    @ManyToOne(cascade = CascadeType.MERGE)
    private BuildPC buildPc;
}
