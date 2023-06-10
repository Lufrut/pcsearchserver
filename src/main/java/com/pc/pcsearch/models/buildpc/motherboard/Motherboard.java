package com.pc.pcsearch.models.buildpc.motherboard;

import com.pc.pcsearch.models.buildpc.FormFactor;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.models.buildpc.Producers;
import com.pc.pcsearch.models.buildpc.processor.CPUGeneration;
import com.pc.pcsearch.models.buildpc.processor.CPUPcieVersion;
import com.pc.pcsearch.models.buildpc.ram.RamMemoryType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data

@Entity
@Table(name = "motheboard")
public class Motherboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private MotherboardSocket socket;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<CPUGeneration> cpuGenerations;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private MotherboardChipset chipset;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private FormFactor formFactor;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Producers motherboardProducer;

    private int maxTdpOfProcessors;

    private int memorySlots;

    private int supportedMemoryFrequency;

    private int maxAmountOfRam;

    @ManyToOne(cascade = CascadeType.MERGE)
    private RamMemoryType ramMemoryType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MotherboardNetwork network;

    private boolean bluetooth;

    private boolean wifi;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CPUPcieVersion pcieVersion;

    private int pci_express_x16;

    private int pci_express_x4;

    private int pci_express_x1;

    private int sata3;

    private int m2;

    private boolean dSub;

    private int dvi;

    private int hdmi;

    private int displayPort;

    private int usb_2_0;

    private int usb_3_0;

    private int usb_type_c;

    private boolean digitalAudioJack;

    private String description;

    private int recommendedPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PerformanceLevel performanceLevel;
}
