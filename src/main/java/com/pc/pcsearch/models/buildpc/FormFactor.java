package com.pc.pcsearch.models.buildpc;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "form_factor")
public class FormFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
}
