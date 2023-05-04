package com.pc.pcsearch.models.buildpc.cooler;
import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "Cooler_socket")
public class CoolerSocket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String socket;
}
