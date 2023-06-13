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
@Table(name = "motherboard")
public class Motherboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private MotherboardSocket socket;

    @ManyToMany
    @JoinTable(
            name = "motherboard_generation",
            joinColumns = @JoinColumn(name = "motherboard_id"),
            inverseJoinColumns = @JoinColumn(name = "cpu_generation_id"))
    private List<CPUGeneration> cpuGenerations;

    @ManyToOne
    private MotherboardChipset chipset;

    @ManyToOne
    private FormFactor formFactor;

    @ManyToOne
    private Producers motherboardProducer;

    private int maxTdpOfProcessors;

    private int memorySlots;

    private int supportedMemoryFrequency;

    private int maxAmountOfRam;

    @ManyToOne
    private RamMemoryType ramMemoryType;

    @ManyToOne
    private MotherboardNetwork network;

    private boolean bluetooth;

    private boolean wifi;

    @ManyToOne
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

    @ManyToOne
    private PerformanceLevel performanceLevel;
}
