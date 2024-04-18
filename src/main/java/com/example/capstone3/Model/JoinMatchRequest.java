package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JoinMatchRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
//    @JsonIgnore
    private Team team;
    @ManyToOne
    @JoinColumn(name = "match_id", referencedColumnName = "id")
//    @JsonIgnore
    private MatchModel matchModel;
    @Enumerated(EnumType.STRING)
    private JoinMatchRequest.RequestStatus status;
    public enum RequestStatus {
        PENDING,
        ACCEPTED,
        REJECTED
    }
}
