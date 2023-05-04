package com.pc.pcsearch.models.build_pc.storage;
import com.pc.pcsearch.models.build_pc.PerformanceLevel;
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
    private StorageProducer producer;

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
