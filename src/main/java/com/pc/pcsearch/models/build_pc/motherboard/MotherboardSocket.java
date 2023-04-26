package com.pc.pcsearch.models.build_pc.motherboard;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "motheboard_socket")
public class MotherboardSocket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String socket;
}
