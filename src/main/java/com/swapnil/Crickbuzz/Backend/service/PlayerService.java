package com.swapnil.Crickbuzz.Backend.service;

import com.swapnil.Crickbuzz.Backend.entity.Player;
import com.swapnil.Crickbuzz.Backend.entity.Team;
import com.swapnil.Crickbuzz.Backend.repo.PlayerRepository;
import com.swapnil.Crickbuzz.Backend.repo.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public Player addPlayerToTeam(Player player, Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        player.setTeam(team);
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
