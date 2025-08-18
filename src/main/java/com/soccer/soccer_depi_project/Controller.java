package com.soccer.soccer_depi_project;

import com.soccer.Manage.LoginRequest;
import com.soccer.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private SoccerRepo repo;

    @PostMapping("/addPlayer")
    public String savePlayer(@RequestBody Player player) {
        repo.save(player);
        return "Added Successfully";
    }

    @GetMapping("/getAllPlayers")
    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return repo.findByEmail(request.getEmail())
                .map(person -> {
                    if (person.getPassword().equals(request.getPassword())) {
                        if ("player".equals(person.getRole())) {
                            return "/playerProfile";
                        } else if ("coach".equals(person.getRole())) {
                            return "/coachProfile";
                        } else {
                            return "Unknown role";
                        }
                    } else {
                        return "Invalid password";
                    }
                })
                .orElse("User not found");
    }
    @GetMapping("/playerProfile")
    public String playerProfile() {
        return "playerProfile";
    }

    @GetMapping("/coachProfile")
    public String coachProfile() {
        return "coachProfile";
    }

}
