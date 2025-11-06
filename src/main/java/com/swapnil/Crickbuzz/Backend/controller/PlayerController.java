package com.swapnil.Crickbuzz.Backend.controller;

import com.swapnil.Crickbuzz.Backend.entity.Player;
import com.swapnil.Crickbuzz.Backend.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@CrossOrigin
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player, @RequestParam Long teamId) {
        return playerService.addPlayerToTeam(player, teamId);
    }
}
