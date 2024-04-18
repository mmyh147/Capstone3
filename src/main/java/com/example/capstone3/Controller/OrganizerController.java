package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.Organizer;
import com.example.capstone3.Service.OrganizerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organizer")
@RequiredArgsConstructor
public class OrganizerController {
    private final OrganizerService organizerService;

    Logger logger = LoggerFactory.getLogger(OrganizerController.class);

    //khaled alkuhaily
    @PostMapping("/add")
    public ResponseEntity addOrganizer(@RequestBody @Valid Organizer organizer){
        organizerService.addOrganizerRepository(organizer);
        logger.info("organizer added");
        return ResponseEntity.ok(new ApiResponse("organizer added"));
    }

    //khaled alkuhaily
    @GetMapping("/organizers")
    public ResponseEntity getAllOrganizers(){
        logger.info("get all organizer");
        return ResponseEntity.ok(organizerService.getAllOrganizers());
    }

    //khaled alkuhaily
    @PutMapping("/update/{organizer_id}")
    public ResponseEntity updateOrganizer(@PathVariable Integer organizer_id, @RequestBody @Valid Organizer organizer){
        organizerService.updateOrganizer(organizer_id, organizer);
        logger.info("organizer updated");
        return ResponseEntity.ok(new ApiResponse("organizer updated"));
    }

    //khaled alkuhaily
    @DeleteMapping("/delete/{organizer_id}")
    public ResponseEntity deleteOrganizer(@PathVariable Integer organizer_id){
        organizerService.deleteOrganizer(organizer_id);
        logger.info("organizer removed");
        return ResponseEntity.ok(new ApiResponse("organizer deleted"));
    }

    //khaled alkuhaily
    @PutMapping("/add-result/{organizer_id}/{match_id}/{result}/{winner}")
    public ResponseEntity addResultToMatch(@PathVariable Integer organizer_id, @PathVariable Integer match_id,
                                           @PathVariable String result, @PathVariable String winner){

        organizerService.addResultToMatch(organizer_id,match_id,result,winner);
        logger.info("organizer added result to match");
        return ResponseEntity.ok(new ApiResponse("added result"));
    }

    //khaled alkuhaily
    @GetMapping("/matches/{organizer_id}/{field_id}")
    public ResponseEntity getAllMatchesByField(@PathVariable Integer organizer_id, @PathVariable Integer field_id){
        logger.info("matches by field");
        return ResponseEntity.ok(organizerService.getAllMatchesByFieldId(organizer_id, field_id));
    }


}
