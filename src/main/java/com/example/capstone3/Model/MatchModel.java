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
import java.util.Set;

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
    private LocalDateTime startDate;
    @NotNull(message = "end date should not be empty")
    private LocalDateTime endDate;
    @JsonIgnore
    private Integer result;
    @JsonIgnore
    private String winner;
    @ManyToOne
    @JoinColumn(name = "field_id ", referencedColumnName = "id")
    @JsonIgnore
    private Field field;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matchModel")
    private Set<Team>teams;
}