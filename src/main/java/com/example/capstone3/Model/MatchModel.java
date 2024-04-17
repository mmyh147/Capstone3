package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MatchModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "StarDate should be not null")
    private LocalDateTime StartDate;

    private LocalDateTime EndDate;
    private Integer result;
    private String winner;
    private String ListTeams;

    @ManyToOne
    @JoinColumn(name = "field_id ", referencedColumnName = "id")
    @JsonIgnore
    private Field field;

}