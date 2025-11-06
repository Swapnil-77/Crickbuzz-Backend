package com.swapnil.Crickbuzz.Backend.controller;

import com.swapnil.Crickbuzz.Backend.entity.Team;
import com.swapnil.Crickbuzz.Backend.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@CrossOrigin
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping
    public Team addTeam(@RequestBody Team team) {
        return teamService.addTeam(team);
    }
}

