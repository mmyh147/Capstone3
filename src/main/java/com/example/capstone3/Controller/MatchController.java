package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.MatchModel;
import com.example.capstone3.Service.MatchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/match")
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;

    Logger logger = LoggerFactory.getLogger(MatchController.class);

    //ahmed alharbi
    @GetMapping("/get")
    public ResponseEntity getAllMatch(){
        logger.info("get all matches");
        return ResponseEntity.status(200).body(matchService.getAllMatch());
    }
    //ahmed alharbi
    @PostMapping("/add/{organizer_id}/{field_id}")
    public ResponseEntity addMatch(@PathVariable Integer organizer_id,@PathVariable Integer field_id ,@RequestBody @Valid MatchModel matchModel){
        matchService.addMatch(organizer_id,field_id, matchModel);
        logger.info("match added");
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }
    //ahmed alharbi
    @PutMapping("update/{id}")
    public ResponseEntity updateMatch(@PathVariable Integer id, @RequestBody @Valid MatchModel matchModel) {
        matchService.UpdateMatch(id, matchModel);
        logger.info("match updated");
        return ResponseEntity.status(200).body(new ApiResponse("Match Update"));
    }

    //ahmed alharbi
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteMatch(@PathVariable Integer id) {
        matchService.deleteMatch(id);
        logger.info("match deleted");
        return ResponseEntity.status(200).body(new ApiResponse("Match delete"));
    }

    //khaled alkuhaily
    @GetMapping("/match/{match_id}")
    public ResponseEntity getMatchById(@PathVariable Integer match_id){
        logger.info("get match by id");
        return ResponseEntity.ok(matchService.findMatchById(match_id));
    }

    //khaled alkuahily
    @GetMapping("/available-matches/{field_id}")
    public ResponseEntity getAvailableMatches(@PathVariable Integer field_id){
        logger.info("get available matches by field");
        return ResponseEntity.ok(matchService.getAllAvailableMatchesByFieldId(field_id));
    }
}
