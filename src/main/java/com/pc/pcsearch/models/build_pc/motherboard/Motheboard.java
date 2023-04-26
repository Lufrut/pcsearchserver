package com.pc.pcsearch.models.build_pc.motherboard;

import com.pc.pcsearch.models.build_pc.FormFactor;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Data

@Entity
@Table(name = "motheboard")
public class Motheboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MotherboardSocket socket;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MotherboardChipset chipset;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private FormFactor formFactor;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MotherboardProducers motherboardProducer;

    private int maxTdpOfProcessors;

    private int memorySlots;

    private int supportedMemoryFrequency;

    private int maxAmountOfRam;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MotherboardNetwork network;

    private boolean bluetooth;

    private boolean wifi;

    private int pcExpressX16;

    private int PciExpressX4;

    private int PciExpressX1;

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
}
