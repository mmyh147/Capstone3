package com.example.capstone3.Repository;

import com.example.capstone3.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    Player findPlayerById(Integer id);
}
