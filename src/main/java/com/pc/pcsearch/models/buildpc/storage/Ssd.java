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

    @ManyToOne
    private Producers producer;

    private String name;

    private int storageSize;

    @ManyToOne
    private StorageFormFactor formFactor;

    @ManyToOne
    private StorageInterface storageInterface;

    private int bufferSize;

    private int readingSpeed;

    private int writingSpeed;

    @ManyToOne
    private SsdCellsType cellsType;

    private String description;

    private int recommendedPrice;

    @ManyToOne
    private PerformanceLevel performanceLevel;
}
