package com.pc.pcsearch.models.build_pc;
import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String login;

    private String password;

    private String email;

}
