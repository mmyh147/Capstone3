package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.JoinMatchRequest;
import com.example.capstone3.Service.JoinMatchRequestService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/request-match")
@RequiredArgsConstructor
public class JoinMatchRequestController {

    private final JoinMatchRequestService joinMatchRequestService;
    Logger logger = LoggerFactory.getLogger(JoinMatchRequestController.class);


    //khaled alkuhaily
    @PostMapping("/request-join/{team_leader_id}/{team_id}/{match_id}")
    public ResponseEntity sendJoinMatchRequest(@PathVariable Integer team_leader_id,@PathVariable Integer team_id, @PathVariable Integer match_id){
        joinMatchRequestService.sendJoinMatchRequest(team_leader_id,team_id, match_id);
        logger.info("sent join match request");
        return ResponseEntity.ok(new ApiResponse("join match request has been sent"));
    }

    //khaled alkuhaily
    @PutMapping("/accept-request/{organizer_id}/{request_id}/{status}")
    public ResponseEntity acceptJoinMatchRequest(@PathVariable Integer organizer_id, @PathVariable Integer request_id
            , @PathVariable String status){
        joinMatchRequestService.acceptJoinMatchRequest(organizer_id, request_id, status);
        logger.info("organizer managed a join match request");
        return ResponseEntity.ok(new ApiResponse("request" + status));
    }

    //khaled alkuhaily
    @GetMapping("view-requests/{organizer_id}/{match_id}")
    public ResponseEntity getJoinRequestsByMatch(@PathVariable Integer organizer_id, @PathVariable Integer match_id){
        logger.info("organizer requested all join requests by match");
        return ResponseEntity.ok(joinMatchRequestService.getAllRequestsByMatchId(organizer_id,match_id));
    }

    //khaled alkuhaily
    @GetMapping("/request/{request_id}")
    public ResponseEntity<JoinMatchRequest> getJoinMatchRequestById(@PathVariable Integer request_id){
        logger.info("get request by id");
        return ResponseEntity.ok(joinMatchRequestService.getJoinMatchRequestById(request_id));
    }



}
