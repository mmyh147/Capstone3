package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.Field;
import com.example.capstone3.Service.FieldService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/field")
@RequiredArgsConstructor
public class FieldController {
    private final FieldService fieldService;
    Logger logger = LoggerFactory.getLogger(FieldController.class);

    @PostMapping("/add/{organizer_id}")
    public ResponseEntity addField(@PathVariable Integer organizer_id, @RequestBody @Valid Field field){
        fieldService.addField(organizer_id, field);
        logger.info("field added");
        return ResponseEntity.ok(new ApiResponse("field added"));
    }

    @GetMapping("/fields")
    public ResponseEntity getAllFields(){
        logger.info("get all fields");
        return ResponseEntity.ok(fieldService.getAllField());
    }

    @PutMapping("/update/{field_id}")
    public ResponseEntity updateField(@PathVariable Integer field_id, @RequestBody @Valid Field field){
        fieldService.updateField(field_id, field);
        logger.info("field updated");
        return ResponseEntity.ok(new ApiResponse("field updated"));
    }


    @DeleteMapping("/delete/{field_id}")
    public ResponseEntity deleteField(@PathVariable Integer field_id){
        fieldService.deleteField(field_id);
        logger.info("field removed");
        return ResponseEntity.ok(new ApiResponse("field deleted"));
    }

    //need test
    @GetMapping("/field/{field_id}")
    public ResponseEntity getFieldById(@PathVariable Integer field_id){
        logger.info("field by id");
        return ResponseEntity.ok(fieldService.getFieldById(field_id));
    }

    @GetMapping("/organizer-fields/{organizer_id}")
    public ResponseEntity getFieldsByOrganizer(@PathVariable Integer organizer_id){
        logger.info("fields by organizer id");
        return ResponseEntity.ok(fieldService.getFieldsByOrganizer(organizer_id));
    }

    //need test
    @GetMapping("/fields-with-matches")
    public ResponseEntity getFieldWithAvailableMatches(){
        logger.info("fields with available matches to join");
        return ResponseEntity.ok(fieldService.getFieldsWithAvailableMatches());
    }

    //need test
    @GetMapping("/fields-location/{keyword}")
    public ResponseEntity getFieldByLocation(@PathVariable String keyword){
        logger.info("fields by location");
        return ResponseEntity.ok(fieldService.getFieldsByLocation(keyword));
    }

    //need test
    @GetMapping("/fields-without-matches/{organizer_id}")
    public ResponseEntity getFieldsWithoutMatches(@PathVariable Integer organizer_id){
        logger.info("fields with no matches");
        return ResponseEntity.ok(fieldService.getFieldsWithNoMatches(organizer_id));
    }


}
