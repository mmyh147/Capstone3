package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//By Mohammed Alhajri
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class JoinRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;
    public enum RequestStatus {
        PENDING,
        ACCEPTED,
        REJECTED
    }
}

