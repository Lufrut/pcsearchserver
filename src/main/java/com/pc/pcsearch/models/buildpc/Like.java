package com.pc.pcsearch.models.buildpc;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private BuildPC buildPc;

    @ManyToOne
    private User user;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "like")
    List<Rating> ratings;

}
