package com.soccer.repository;

import com.soccer.event.MedicalRecord;
import com.soccer.event.TrainingSession;
import com.soccer.model.Coach;
import com.soccer.model.Player;
import com.soccer.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private CoachRepo coachRepo;

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private MedicalRecordRepository recordRepo;

    @Autowired
    private TrainingSessionRepo sessionRepo;

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

    @GetMapping("player/id/{id}")
    public Player getPlayerById(@PathVariable String id) {
        return playerRepo.findById(id).orElseThrow();
    }
    @GetMapping("coach/id/{id}")
    public Coach getCoachById(@PathVariable String id) {
        return coachRepo.findById(id).orElseThrow();
    }

    @GetMapping("player/email/{email}")
    public Player getPlayerByEmail(@PathVariable String email) {
        return playerRepo.findByEmail(email).orElseThrow();
    }

    @GetMapping("coach/email/{email}")
    public Coach getCoachByEmail(@PathVariable String email) {
        return coachRepo.findByEmail(email).orElseThrow();
    }

    @GetMapping("/team/{id}")
    public Team getTeamById(@PathVariable String id) {
        return teamRepo.findById(id).orElseThrow();
    }

    @GetMapping("/team/getPlayers/{name}")
    public ArrayList<Player> getTeamPlayersByName(@PathVariable String name) {
        Team team = teamRepo.findByName(name).orElseThrow(() -> new RuntimeException("Team not found with name: " + name)
        );
        ArrayList<String> playerIds = team.getPlayersIds();
        return playerRepo.findAllByName(playerIds);
    }
    @PostMapping("/team/{teamId}/addPlayer/{playerEmail}")
    public ResponseEntity<String> addPlayerToTeam(@PathVariable String teamId, @PathVariable String playerEmail) {
        Optional<Team> optionalTeam = teamRepo.findById(teamId);
        if (optionalTeam.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Optional<Player> playerOpt = playerRepo.findByEmail(playerEmail);
        if (playerOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Player not found");
        }
        Player player = playerOpt.get();
        Team team = optionalTeam.get();
        if (team.isExistPlayer(player.getId())) {
            return ResponseEntity.badRequest().body("Player already in team");
        }
        team.addPlayer(player.getId());
        teamRepo.save(team);

        return ResponseEntity.ok("Player added successfully");
    }

    @DeleteMapping("/team/{teamId}/removePlayer")
    public ResponseEntity<String> removePlayerFromTeam(@PathVariable String teamId, @RequestParam String playerId) {
        Optional<Team> optionalTeam = teamRepo.findById(teamId);
        if (optionalTeam.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Team team = optionalTeam.get();
        if (!team.isExistPlayer(playerId)) {
            return ResponseEntity.badRequest().body("Player not in team");
        }
        team.removePlayer(playerId);
        teamRepo.save(team);
        return ResponseEntity.ok("Player removed successfully");
    }

    @PutMapping("/player/{playerId}/{injuryStatus}")
    public ResponseEntity<String> updateInjuryStatus(@PathVariable String playerId, @PathVariable boolean injuryStatus) {
        Optional<Player> optionalPlayer = playerRepo.findById(playerId);
        if (optionalPlayer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Player player = optionalPlayer.get();
        if (injuryStatus) {
            player.markInjured();
        } else {
            player.recover();
        }
        playerRepo.save(player);
        return ResponseEntity.ok("Player injury status updated");
    }

    @GetMapping("/medicalRecord/{playerId}")
    public MedicalRecord getMedicalRecord(@PathVariable String playerId) {
        return recordRepo.findByPlayerId(playerId).orElseThrow();
    }
    @PostMapping("/trainingSession/add")
    public TrainingSession addSession(@RequestBody TrainingSession session) {
        return sessionRepo.save(session);
    }
    @GetMapping("/trainingSession/coach/{coachName}")
    public List<TrainingSession> getSessionsByCoach(@PathVariable String coachName) {
        return sessionRepo.findByCoachName(coachName);
    }

}