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


    @GetMapping("get")
    public ResponseEntity getAllTeam(){
        logger.info("get all team");

        return ResponseEntity.ok(teamService.getAll());
    }

    @PostMapping("add/{playerid}")
    public ResponseEntity addTeam(@PathVariable Integer playerid, @RequestBody @Valid Team team){
        logger.info("add team");
        teamService.add(playerid, team);
        return ResponseEntity.ok("team added");
    }

    @PutMapping("update/{teamid}")
    public ResponseEntity updatePlayer(@PathVariable Integer teamid, @RequestBody @Valid Team team){
        logger.info("update team");

        teamService.update(teamid, team);
        return ResponseEntity.status(200).body("team updated");


    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTeam(@PathVariable Integer id){
        logger.info("delete team");

        teamService.delete(id);
        return ResponseEntity.status(200).body("team deleted");
    }


    @PutMapping("leave/{player_id}")
    public ResponseEntity leaveTeam(@PathVariable Integer player_id){
        logger.info("leave team");

        teamService.leaveTeam(player_id);
        return ResponseEntity.status(200).body("You leaved the team");
    }



}
