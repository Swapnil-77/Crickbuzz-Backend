package com.swapnil.Crickbuzz.Backend.service;

import com.swapnil.Crickbuzz.Backend.entity.Match;
import com.swapnil.Crickbuzz.Backend.entity.Team;
import com.swapnil.Crickbuzz.Backend.repo.MatchRepository;
import com.swapnil.Crickbuzz.Backend.repo.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    public MatchService(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    public Match addMatch(Match match, Long teamAId, Long teamBId) {
        Team teamA = teamRepository.findById(teamAId)
                .orElseThrow(() -> new RuntimeException("Team A not found"));
        Team teamB = teamRepository.findById(teamBId)
                .orElseThrow(() -> new RuntimeException("Team B not found"));
        match.setTeamA(teamA);
        match.setTeamB(teamB);
        return matchRepository.save(match);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public List<Match> getMatchesByTeam(Long teamId) {
        return matchRepository.findByTeamA_IdOrTeamB_Id(teamId, teamId);
    }

    // ✅ Fixed: only fetches matches between the two specific teams
    public List<Match> getMatchesByTeamNames(String teamA, String teamB) {
        Team teamAEntity = teamRepository.findByName(teamA)
                .orElseThrow(() -> new RuntimeException("Team A not found"));
        Team teamBEntity = teamRepository.findByName(teamB)
                .orElseThrow(() -> new RuntimeException("Team B not found"));

        // Use correct repository method
        return matchRepository.findMatchesBetweenTeams(
                teamAEntity.getId(),
                teamBEntity.getId()
        );
    }
}


