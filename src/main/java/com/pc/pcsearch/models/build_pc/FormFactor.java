package com.pc.pcsearch.models.build_pc;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "form_factor")
public class FormFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String formFactor;
}
