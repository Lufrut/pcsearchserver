package com.pc.pcsearch.models.buildpc.storage;
import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "storage_producer")
public class StorageProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
}