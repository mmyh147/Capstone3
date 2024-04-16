package com.example.capstone3.Service;


import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Player;
import com.example.capstone3.Model.Team;
import com.example.capstone3.Repository.PlayerRepository;
import com.example.capstone3.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;


    public List<Team> getAll() {
        return teamRepository.findAll();
    }


    public void add(Integer player_id, Team team) {
        Player player = playerRepository.findPlayerById(player_id);
        if (player == null){
            throw new ApiException("player not found");
        }
        player.setRole("Captain");
        playerRepository.save(player);
        teamRepository.save(team);
    }

    public void update(Integer teamId, Team team) {
        if (teamRepository.existsById(teamId)) {
            team.setId(teamId);
            teamRepository.save(team);
        }else{
            throw new ApiException("team not found");

        }
    }

    public void delete(Integer id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
        } else {
            throw new ApiException("team not found");
        }


    }
}
