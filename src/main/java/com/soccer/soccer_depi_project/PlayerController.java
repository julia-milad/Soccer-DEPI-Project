//package com.soccer.soccer_depi_project;
//
//import com.soccer.model.Player;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/players")
//public class PlayerController {
//
//    @Autowired
//    private PlayerRepo playerRepo;
//
//    @GetMapping("/email/{email}")
//    public Optional<Player> getPlayer(@PathVariable String email) {
//        return playerRepo.findByEmail(email);
//    }
//
//    @GetMapping
//    public Iterable<Player> getAllPlayers() {
//        return playerRepo.findAll();
//    }
//}
