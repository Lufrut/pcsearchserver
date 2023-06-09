package com.pc.pcsearch.models.buildpc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pc.pcsearch.models.buildpc.cooler.Cooler;
import com.pc.pcsearch.models.buildpc.graphiccard.GraphicCard;
import com.pc.pcsearch.models.buildpc.motherboard.Motherboard;
import com.pc.pcsearch.models.buildpc.pccase.PCCase;
import com.pc.pcsearch.models.buildpc.powersupply.PowerSupply;
import com.pc.pcsearch.models.buildpc.processor.Processor;
import com.pc.pcsearch.models.buildpc.ram.Ram;
import com.pc.pcsearch.models.buildpc.storage.Hdd;
import com.pc.pcsearch.models.buildpc.storage.Ssd;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data

@Entity
@Table(name = "build_pc")
public class BuildPC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nameOfBuild;

    @ManyToOne
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Motherboard motherboard;

    @ManyToOne(fetch = FetchType.EAGER)
    private Processor processor;

    @ManyToOne(fetch = FetchType.EAGER)
    private GraphicCard graphicCard;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Build_pc_ram",
            joinColumns = @JoinColumn(name = "Build_pc_id"),
            inverseJoinColumns = @JoinColumn(name = "ram_id"))
    private List<Ram> ram;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private PowerSupply powerSupply;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Build_pc_hdd",
            joinColumns = @JoinColumn(name = "Build_pc_id"),
            inverseJoinColumns = @JoinColumn(name = "hdd_id"))
    private List<Hdd> hdd;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Build_pc_ssd",
            joinColumns = @JoinColumn(name = "Build_pc_id"),
            inverseJoinColumns = @JoinColumn(name = "ssd_id"))
    private List<Ssd> ssd;

    @ManyToOne(fetch = FetchType.EAGER)
    private PCCase pcCase;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cooler cooler;

    private int countOfLikes;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private Rating ratingId;

    private int totalPrice;
}
