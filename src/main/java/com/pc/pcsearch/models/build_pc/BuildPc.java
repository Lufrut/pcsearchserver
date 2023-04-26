package com.pc.pcsearch.models.build_pc;

import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "Build_pc")
public class BuildPc{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name_of_build")
    private String nameOfBuild;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "motherboard")
    private int motherboard;

    @Column(name = "processor")
    private int processor;

    @Column(name = "graphiccard")
    private int graphicCard;

    @Column(name = "ram")
    private int ram;

    @Column(name = "power_supply")
    private int powerSupply;

    @Column(name = "hdd")
    private int hdd;

    @Column(name = "ssd")
    private int ssd;

    @Column(name = "pc_case")
    private int pcCase;

    @Column(name = "cooler")
    private int cooler;

    @Column(name = "count_of_likes")
    private int countOfLikes;

    @Column(name = "rating_id")
    private int ratingId;
}
