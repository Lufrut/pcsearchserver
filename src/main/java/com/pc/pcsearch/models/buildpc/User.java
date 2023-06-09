package com.pc.pcsearch.models.buildpc;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {

    public User(){
    }
    public User(String name, String username, String password, ERole role, String email){
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @NotBlank
    private String username;

    @NotBlank
    @JsonIgnore
    private String password;

    private ERole role;

    @NotBlank
    @Email
    private String email;

    @JsonIgnore
    @OneToMany(orphanRemoval = true, cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<BuildPC> buildPc;
}
