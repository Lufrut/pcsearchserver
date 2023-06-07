package com.pc.pcsearch.models.buildpc;

import com.pc.pcsearch.models.buildpc.cooler.Cooler;
import com.pc.pcsearch.models.buildpc.graphiccard.GraphicCard;
import com.pc.pcsearch.models.buildpc.motherboard.Motherboard;
import com.pc.pcsearch.models.buildpc.pccase.Case;
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
@Table(name = "Build_pc")
public class BuildPC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nameOfBuild;

    @ManyToOne
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Motherboard motherboard;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Processor processor;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private GraphicCard graphicCard;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Ram> ram;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private PowerSupply powerSupply;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Hdd> hdd;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Ssd> ssd;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Case pcCase;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Cooler cooler;

    private int countOfLikes;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Rating ratingId;

    private int totalPrice;
}
