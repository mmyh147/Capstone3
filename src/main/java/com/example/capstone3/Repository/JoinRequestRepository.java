package com.example.capstone3.Repository;

import com.example.capstone3.Model.JoinRequest;
import com.example.capstone3.Model.Player;
import com.example.capstone3.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface JoinRequestRepository extends JpaRepository<JoinRequest, Integer> {

    JoinRequest findJoinRequestById(Integer id);

    Set<JoinRequest> findAllByTeam(Team team);

    Set<JoinRequest> findByPlayer(Player player);


}
