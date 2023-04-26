package com.pc.pcsearch.models.build_pc.motherboard;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "motheboard_network")
public class MotherboardNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String network;
}
