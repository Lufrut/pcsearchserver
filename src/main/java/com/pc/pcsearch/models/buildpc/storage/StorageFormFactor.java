package com.pc.pcsearch.models.buildpc.storage;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "storage_form_factor")
public class StorageFormFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
}
