package com.pc.pcsearch.models.buildpc.storage;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.models.buildpc.Producers;
import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "ssd")
public class Ssd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Producers producer;

    private String name;

    private int storageSize;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private StorageFormFactor formFactor;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private StorageInterface storageInterface;

    private int bufferSize;

    private int readingSpeed;

    private int writingSpeed;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private SsdCellsType cellsType;

    private String description;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private PerformanceLevel performanceLevel;
}
