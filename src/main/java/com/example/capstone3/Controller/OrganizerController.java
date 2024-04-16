package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.Organizer;
import com.example.capstone3.Service.OrganizerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Organizer")
@RequiredArgsConstructor
public class OrganizerController {
    private final OrganizerService organizerService;


    @PostMapping("/add")
    public ResponseEntity addOrganizer(@RequestBody @Valid Organizer organizer){
        organizerService.addOrganizerRepository(organizer);
        return ResponseEntity.ok(new ApiResponse("organizer added"));
    }

    @GetMapping("/organizers")
    public ResponseEntity getAllOrganizers(){
        return ResponseEntity.ok(organizerService.getAllOrganizers());
    }

    @PutMapping("/update/{organizer_id}")
    public ResponseEntity updateOrganizer(@PathVariable Integer organizer_id, @RequestBody @Valid Organizer organizer){
        organizerService.updateOrganizer(organizer_id, organizer);
        return ResponseEntity.ok(new ApiResponse("organizer updated"));
    }

    @DeleteMapping("/delete/{organizer_id}")
    public ResponseEntity deleteOrganizer(@PathVariable Integer organizer_id){
        organizerService.deleteOrganizer(organizer_id);
        return ResponseEntity.ok(new ApiResponse("organizer deleted"));
    }


}
