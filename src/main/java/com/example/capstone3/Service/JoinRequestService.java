package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.JoinRequest;
import com.example.capstone3.Model.Player;
import com.example.capstone3.Model.Team;
import com.example.capstone3.Repository.JoinRequestRepository;
import com.example.capstone3.Repository.PlayerRepository;
import com.example.capstone3.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JoinRequestService {


    private final JoinRequestRepository joinRequestRepository;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;


    public List<JoinRequest> getAll() {
        return joinRequestRepository.findAll();
    }

    public JoinRequest sendJoinRequest(Integer player_id, Integer team_id) {
        Player player = playerRepository.findPlayerById(player_id);
        Team team = teamRepository.findTeamById(team_id);
        if (player.getTeam() != null){
            throw new ApiException("you need to leave your current team before join");
        }
        if (player == null){
            throw new ApiException("player not found");
        }
        if (team == null){
            throw new ApiException("team not found");
        }
        JoinRequest request = new JoinRequest();
        request.setPlayer(player);
        request.setTeam(team);
        request.setStatus(JoinRequest.RequestStatus.PENDING);
        return joinRequestRepository.save(request);
    }

    public void acceptJoinRequest(Integer request_id, String status) {
        JoinRequest joinRequest = joinRequestRepository.findJoinRequestById(request_id);


        if (joinRequest == null){
            throw new ApiException("Request not found");
        }
        Player player = joinRequest.getPlayer();
        if (player.getTeam() !=null){
            throw new ApiException("player Already in team");
        }
        Team team = joinRequest.getTeam();
        if (status.equals("ACCEPTED")){
            joinRequest.setStatus(JoinRequest.RequestStatus.ACCEPTED);
            joinRequestRepository.save(joinRequest);
            player.setTeam(team);
            playerRepository.save(player);

        } else if (status.equals("REJECTED")) {
            joinRequest.setStatus(JoinRequest.RequestStatus.REJECTED);

        }else{
            throw new ApiException("must be ACCEPTED or REJECTED");
        }


    }

//    public void rejectJoinRequest(JoinRequest request) {
//        request.setStatus(JoinRequest.RequestStatus.REJECTED);
//        joinRequestRepository.save(request);
//    }

    public Set<JoinRequest> findJoinRequestsByTeam(Integer team_id) {
        Team team = teamRepository.findTeamById(team_id);
        if (team == null){
            throw new ApiException("team not found");
        }
        return joinRequestRepository.findAllByTeam(team);
    }

    public Set<JoinRequest> findJoinRequestsByPlayer(Integer player_id) {
        Player player = playerRepository.findPlayerById(player_id);
        if (player == null){
            throw new ApiException("player not found");
        }
        return joinRequestRepository.findByPlayer(player);
    }

}
