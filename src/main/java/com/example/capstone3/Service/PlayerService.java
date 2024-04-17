package com.example.capstone3.Service;


import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Player;
import com.example.capstone3.Repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;


    public List<Player> getAll() {
        return playerRepository.findAll();
    }


    public void add(Player player) {
        playerRepository.save(player);
    }

    public void update(Integer playerId, Player player) {
        if (playerRepository.existsById(playerId)) {
            player.setId(playerId);
            playerRepository.save(player);
        }else{
            throw new ApiException("player not found");

        }
    }

    public void delete(Integer id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
        } else {
            throw new ApiException("player not found");
        }


    }

    public Player getPlayerById(Integer player_id){
        Player player = playerRepository.findPlayerById(player_id);
        if (player == null){
            throw new ApiException("Player with ID : " + player_id + " not found");
        }
        return player;
    }
}
