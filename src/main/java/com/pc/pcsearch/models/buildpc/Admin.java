package com.pc.pcsearch.models.buildpc;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String login;

    private String password;

    private String email;
}