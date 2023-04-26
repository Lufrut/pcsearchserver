package com.pc.pcsearch.models.build_pc.storage;
import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "storage_interface")
public class StorageInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
}
