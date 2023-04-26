package com.pc.pcsearch.models.build_pc.storage;

import com.pc.pcsearch.models.build_pc.PerfomanceLevel;
import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "hdd")
public class Hdd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private StorageProducer producer;

    private int storageSize;

    private int speed;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private StorageFormFactor formFactor;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private StorageInterface storageInterface;

    private int bufferSize;

    private int readingSpeed;

    private int writingSpeed;

    private String description;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PerfomanceLevel perfomanceLevel;
}
