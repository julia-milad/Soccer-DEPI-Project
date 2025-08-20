package com.soccer.soccer_depi_project;

import com.soccer.Manage.LoginRequest;
import com.soccer.model.Coach;
import com.soccer.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private CoachRepo coachRepo;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        if ("Player".equalsIgnoreCase(request.getRole())) {
            return playerRepo.findByEmail(request.getEmail())
                    .map(player -> {
                        if (player.getPassword().equals(request.getPassword())) {
                            return "/playerProfile";
                        } else {
                            return "login";
                        }
                    })
                    .orElse("Something wrong ,please try again");
        } else if ("Coach".equalsIgnoreCase(request.getRole())) {
            return coachRepo.findByEmail(request.getEmail())
                    .map(coach -> {
                        if (coach.getPassword().equals(request.getPassword())) {
                            return "/coachProfile";
                        } else {
                            return "login";
                        }
                    })
                    .orElse("Something wrong ,please try again");
        } else {
            return "login";
        }
    }
    @GetMapping("/playerProfile")
    public String playerProfile() {
        return "playerProfile";
    }

    @GetMapping("/coachProfile")
    public String coachProfile() {
        return "coachProfile";
    }
    @GetMapping("player/email/{email}")
    public Player getPlayer(@PathVariable String email) {
        return playerRepo.findByEmail(email).orElseThrow();
    }
    @GetMapping("coach/email/{email}")
    public Coach getCoach(@PathVariable String email) {
        return coachRepo.findByEmail(email).orElseThrow();
    }
}
