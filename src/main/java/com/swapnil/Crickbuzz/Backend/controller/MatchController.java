package com.swapnil.Crickbuzz.Backend.controller;

import com.swapnil.Crickbuzz.Backend.entity.Match;
import com.swapnil.Crickbuzz.Backend.service.MatchService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/match")
@CrossOrigin
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public Match addMatch(@RequestBody Match match,
                          @RequestParam Long teamAId,
                          @RequestParam Long teamBId) {
        return matchService.addMatch(match, teamAId, teamBId);
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/by-team")
    public List<Match> getMatchesByTeam(@RequestParam Long teamId) {
        return matchService.getMatchesByTeam(teamId);
    }

    // ✅ Updated method
    @GetMapping("/by-teams")
    public List<Match> getMatchesByTeamNames(
            @RequestParam String teamA,
            @RequestParam String teamB) {
        return matchService.getMatchesByTeamNames(teamA, teamB);
    }
}
