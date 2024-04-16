package com.example.capstone3.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name must be not null")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotNull(message = "age must not be empty")
    @Column(columnDefinition = "int not null")
    @Min(15)
    private Integer age;
    @NotEmpty(message = "phone must be not null")
    @Column(columnDefinition = "varchar(10) not null")
    private String phone;
    @Column(columnDefinition = "varchar(30) not null")
    @NotEmpty(message = "email must be not null")
    private String email;

    private String role;


    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    @JsonIgnore
    private Team team;

}