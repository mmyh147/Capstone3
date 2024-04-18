package com.example.capstone3.Controller;


import com.example.capstone3.Model.Player;
import com.example.capstone3.Model.Team;
import com.example.capstone3.Service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/team")
public class TeamController {


    private final TeamService teamService;
    Logger logger = LoggerFactory.getLogger(TeamController.class);

//By Mohammed Alhajri

    @GetMapping("get")
    public ResponseEntity getAllTeam(){
        logger.info("get all team");

        return ResponseEntity.ok(teamService.getAll());
    }
//By Mohammed Alhajri

    @GetMapping("get-by-id/{id}")
    public ResponseEntity getTeamById(@PathVariable Integer id){
        logger.info("get team by ID : " + id);

        return ResponseEntity.ok(teamService.getTeamById(id));
    }
//By Mohammed Alhajri

    @PostMapping("add/{playerid}")
    public ResponseEntity addTeam(@PathVariable Integer playerid, @RequestBody @Valid Team team){
        logger.info("add team");
        teamService.add(playerid, team);
        return ResponseEntity.ok("team added");
    }
//By Mohammed Alhajri

    @PutMapping("update/{teamid}")
    public ResponseEntity updatePlayer(@PathVariable Integer teamid, @RequestBody @Valid Team team){
        logger.info("update team");

        teamService.update(teamid, team);
        return ResponseEntity.status(200).body("team updated");


    }

//By Mohammed Alhajri

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTeam(@PathVariable Integer id){
        logger.info("delete team");

        teamService.delete(id);
        return ResponseEntity.status(200).body("team deleted");
    }

//By Mohammed Alhajri

    @PutMapping("leave/{player_id}")
    public ResponseEntity leaveTeam(@PathVariable Integer player_id){
        logger.info("leave team");

        teamService.leaveTeam(player_id);
        return ResponseEntity.status(200).body("You leaved the team");
    }
//By Mohammed Alhajri

    @PutMapping("kick/{player_id}/{leader_id}/{team_id}")
    public ResponseEntity kickPlayer(@PathVariable Integer player_id, @PathVariable Integer leader_id, @PathVariable Integer team_id){
        logger.info("kick player");

        teamService.kickPlayer(player_id, leader_id, team_id);
        return ResponseEntity.status(200).body("player with ID : " + player_id + " has been kicked");
    }
//By Mohammed Alhajri

    @PutMapping("change/{new_leader_id}/{leader_id}/{team_id}")
    public ResponseEntity changeLeader(@PathVariable Integer new_leader_id, @PathVariable Integer leader_id, @PathVariable Integer team_id){
        logger.info("change leader to player with ID : " + new_leader_id);

        teamService.changeLeader(new_leader_id, leader_id, team_id);
        return ResponseEntity.status(200).body("player with ID : " + new_leader_id + " has become leader");
    }

    //by khaled alkuhaily
    @GetMapping("/matches/{team_id}")
    public ResponseEntity getTeamMatches(@PathVariable Integer team_id){
        logger.info("requested matches by team");
        return ResponseEntity.ok(teamService.getTeamMatches(team_id));
    }


}
