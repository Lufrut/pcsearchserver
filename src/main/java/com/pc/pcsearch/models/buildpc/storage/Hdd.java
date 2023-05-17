package com.pc.pcsearch.models.buildpc.storage;

import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.models.buildpc.Producers;
import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "hdd")
public class Hdd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Producers producer;

    private int storageSize;

    private int speed;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private StorageFormFactor formFactor;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private StorageInterface storageInterface;

    private int bufferSize;

    private int readingSpeed;

    private int writingSpeed;

    private String description;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private PerformanceLevel performanceLevel;
}
