package com.pc.pcsearch.models.buildpc;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "producers")
public class Producers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
}
