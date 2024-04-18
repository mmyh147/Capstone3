package com.example.capstone3.Controller;


import com.example.capstone3.Model.Team;
import com.example.capstone3.Service.JoinRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/request")
public class JoinRequestController {



    private final JoinRequestService joinRequestService;
    Logger logger = LoggerFactory.getLogger(TeamController.class);

//By Mohammed Alhajri

    @GetMapping("get")
    public ResponseEntity getAllRequest(){
        logger.info("get all request");

        return ResponseEntity.ok(joinRequestService.getAll());
    }
//By Mohammed Alhajri

    @GetMapping("get-by-id/{request_id}")
    public ResponseEntity getRequestById(@PathVariable Integer request_id){
        logger.info("get request by Id: " + request_id);

        return ResponseEntity.ok(joinRequestService.findRequestById(request_id));
    }
//By Mohammed Alhajri

    @PostMapping("add/{playerid}/{teamid}")
    public ResponseEntity add(@PathVariable Integer playerid, @PathVariable Integer teamid){
        logger.info("add request");
        joinRequestService.sendJoinRequest(playerid, teamid);
        return ResponseEntity.ok("add request");
    }
//By Mohammed Alhajri

    @PutMapping("status/{leader_id}/{requestid}/{status}")
    public ResponseEntity joinTeamStatus(@PathVariable Integer leader_id, @PathVariable Integer requestid, @PathVariable String status){
        logger.info("update request");
        joinRequestService.acceptJoinRequest(leader_id, requestid, status);
        return ResponseEntity.ok("request updated");
    }

//By Mohammed Alhajri

    @GetMapping("get/all/{team_id}")
    public ResponseEntity getAllTeamRequest(@PathVariable Integer team_id){
        logger.info("get all team request");

        return ResponseEntity.ok(joinRequestService.findJoinRequestsByTeam(team_id));
    }
//By Mohammed Alhajri

    @GetMapping("get/player/{player_id}")
    public ResponseEntity getAllPlayerRequest(@PathVariable Integer player_id){
        logger.info("get all player request");

        return ResponseEntity.ok(joinRequestService.findJoinRequestsByPlayer(player_id));
    }
//By Mohammed Alhajri

    @GetMapping("stats/{team_id}/{status}")
    public ResponseEntity getRequestByStatusAndTeam(@PathVariable String status ,@PathVariable Integer team_id){
        logger.info("get all request by status and team");

        return ResponseEntity.ok(joinRequestService.findJoinRequestsByStatusAndTeam(status, team_id));
    }




}
