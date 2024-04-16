package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.Field;
import com.example.capstone3.Service.FieldService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/field")
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;

    @PostMapping("/add/{organizer_id}")
    public ResponseEntity addField(@PathVariable Integer organizer_id, @RequestBody @Valid Field field){
        fieldService.addField(organizer_id, field);
        return ResponseEntity.ok(new ApiResponse("field added"));
    }

    @GetMapping("/fields")
    public ResponseEntity getAllFields(){
        return ResponseEntity.ok(fieldService.getAllField());
    }

    @PutMapping("/update/{field_id}")
    public ResponseEntity updateField(@PathVariable Integer field_id, @RequestBody @Valid Field field){
        fieldService.updateField(field_id, field);
        return ResponseEntity.ok(new ApiResponse("field updated"));
    }


    @DeleteMapping("/delete/{field_id}")
    public ResponseEntity deleteField(@PathVariable Integer field_id){
        fieldService.deleteField(field_id);
        return ResponseEntity.ok(new ApiResponse("field deleted"));
    }

}
