package com.pc.pcsearch.models.buildpc.storage;
import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "ssd_cells_type")
public class SsdCellsType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
}
