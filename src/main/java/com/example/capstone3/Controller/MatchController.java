package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.MatchModel;
import com.example.capstone3.Service.MatchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/match")
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;

    @GetMapping("/get")
    public ResponseEntity getAllMatch()

    {
        return ResponseEntity.status(200).body(matchService.getAllMatch());
    }

    @PostMapping("/add/{organizer_id}/{field_id}")
    public ResponseEntity addMatch(@PathVariable Integer organizer_id,@PathVariable Integer field_id ,@RequestBody @Valid MatchModel matchModel){
        matchService.addMatch(organizer_id,field_id, matchModel);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateMatch(@PathVariable Integer id, @RequestBody @Valid MatchModel matchModel) {
        matchService.UpdateMatch(id, matchModel);
        return ResponseEntity.status(200).body(new ApiResponse("Match Update"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteMatch(@PathVariable Integer id) {
        matchService.deleteMatch(id);
        return ResponseEntity.status(200).body(new ApiResponse("Match delete"));
    }

    @GetMapping("/match/{match_id}")
    public ResponseEntity getMatchById(@PathVariable Integer match_id){
        return ResponseEntity.ok(matchService.findMatchById(match_id));
    }

    @GetMapping("/available-matches/{field_id}")
    public ResponseEntity getAvailableMatches(@PathVariable Integer field_id){
        return ResponseEntity.ok(matchService.getAllAvailableMatchesByFieldId(field_id));
    }


}