package com.pc.pcsearch.models.buildpc.motherboard;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "motheboard_chipset")
public class MotherboardChipset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String chipset;
}
