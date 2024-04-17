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


    @GetMapping("get")
    public ResponseEntity getAllRequest(){
        logger.info("get all request");

        return ResponseEntity.ok(joinRequestService.getAll());
    }

    @PostMapping("add/{playerid}/{teamid}")
    public ResponseEntity add(@PathVariable Integer playerid, @PathVariable Integer teamid){
        logger.info("add request");
        joinRequestService.sendJoinRequest(playerid, teamid);
        return ResponseEntity.ok("add request");
    }

    @PutMapping("status/{requestid}/{status}")
    public ResponseEntity add(@PathVariable Integer requestid, @PathVariable String status){
        logger.info("update request");
        joinRequestService.acceptJoinRequest(requestid, status);
        return ResponseEntity.ok("request updated");
    }
}
