package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.MatchModel;
import com.example.capstone3.Service.MatchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Match")
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;

    @GetMapping("/get")
    public ResponseEntity getAllMatch()

    {
        return ResponseEntity.status(200).body(matchService.getAllMatch());
    }

    @PostMapping("/add/{field_id}")
    public ResponseEntity addMatch(@PathVariable Integer field_id ,@RequestBody @Valid MatchModel matchModel){
        matchService.addMatch(field_id, matchModel);
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
    @GetMapping("assign/{match_id}/{firstTeam_id},{secondTeam_id}")
    public ResponseEntity assignTeamsToMatch(@PathVariable Integer match_id, @PathVariable Integer firstTeam_id, @PathVariable Integer secondTeam_id){
        matchService.assignTeamsToMatch(match_id, firstTeam_id, secondTeam_id);
        return ResponseEntity.status(200).body(new ApiResponse("Assign DONE"));
    }
}