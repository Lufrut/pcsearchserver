package com.pc.pcsearch.models.build_pc.storage;
import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "ssd_cells_type")
public class SsdCellsType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
}
