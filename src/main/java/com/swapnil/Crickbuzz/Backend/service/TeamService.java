package com.swapnil.Crickbuzz.Backend.service;

import com.swapnil.Crickbuzz.Backend.entity.Team;
import com.swapnil.Crickbuzz.Backend.repo.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
