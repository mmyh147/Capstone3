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

//By Mohammed Alhajri

    @GetMapping("get")
    public ResponseEntity getAllPlayer(){
        logger.info("get all player");

        return ResponseEntity.ok(playerService.getAll());
    }
//By Mohammed Alhajri

    @PostMapping("/add")
    public ResponseEntity addPlayer(@RequestBody @Valid Player player){
        logger.info("add Player");
        playerService.add(player);
        return ResponseEntity.ok("player added");
    }
//By Mohammed Alhajri

    @PutMapping("/update/{playerid}")
    public ResponseEntity updatePlayer(@PathVariable Integer playerid, @RequestBody @Valid Player player){
        logger.info("update player");

        playerService.update(playerid, player);
        return ResponseEntity.status(200).body("player updated");


    }

//By Mohammed Alhajri

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlayer(@PathVariable Integer id){
        logger.info("delete player");

        playerService.delete(id);
        return ResponseEntity.status(200).body("player deleted");
    }
//By Mohammed Alhajri

    @GetMapping("get/player/{player_id}")
    public ResponseEntity getPlayerById(@PathVariable Integer player_id){
        logger.info("get player by ID : " + player_id);

        return ResponseEntity.ok(playerService.getPlayerById(player_id));
    }

    //By Mohammed Alhajri
    @GetMapping("/count")
    public ResponseEntity getPlayerCount() {
        return ResponseEntity.ok(playerService.getPlayerCount());
    }
}
