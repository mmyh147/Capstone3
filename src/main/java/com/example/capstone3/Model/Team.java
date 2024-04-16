package com.example.capstone3.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private Set<Player> players;




}
