package com.example.capstone3.Controller;


import com.example.capstone3.Model.Player;
import com.example.capstone3.Service.PlayerService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/player")
public class PlayerController {


    private final PlayerService playerService;
    Logger logger = LoggerFactory.getLogger(PlayerController.class);


    @GetMapping("get")
    public ResponseEntity getAllPlayer(){
        logger.info("get all player");

        return ResponseEntity.ok(playerService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity addPlayer(@RequestBody @Valid Player player){
        logger.info("add Player");
        playerService.add(player);
        return ResponseEntity.ok("player added");
    }

    @PutMapping("update/{playerid}")
    public ResponseEntity updatePlayer(@PathVariable Integer playerid, @RequestBody @Valid Player player){
        logger.info("update player");

        playerService.update(playerid, player);
        return ResponseEntity.status(200).body("player updated");


    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity deletePlayer(@PathVariable Integer id){
        logger.info("delete player");

        playerService.delete(id);
        return ResponseEntity.status(200).body("player deleted");
    }
}
