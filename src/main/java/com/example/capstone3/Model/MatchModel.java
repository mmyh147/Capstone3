package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
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
    @FutureOrPresent(message = "start date should be present or in the future")
    private LocalDateTime startDate;
    @NotNull(message = "end date should not be empty")
    @Future(message = "end date should be on the future")
    private LocalDateTime endDate;
//    @Column(columnDefinition = "VARCHAR(8) NOT NULL CHECK(status='available' or status='waiting' or status='finished'")
    private String status;
    private String result;
    private String winner;

    @ManyToOne
    @JoinColumn(name = "field_id ", referencedColumnName = "id")
    @JsonIgnore
    private Field field;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matchModel")
    @JsonIgnore
    private Set<JoinMatchRequest> joinMatchRequests;

    @ManyToMany(mappedBy = "matchModel")
    private Set<Team>teams;

}