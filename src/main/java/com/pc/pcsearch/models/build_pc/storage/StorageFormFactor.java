package com.pc.pcsearch.models.build_pc.storage;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "storage_form_factor")
public class StorageFormFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
}
