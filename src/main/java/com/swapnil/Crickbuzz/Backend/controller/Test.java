package com.swapnil.Crickbuzz.Backend.controller;

import com.swapnil.Crickbuzz.Backend.entity.Match;
import com.swapnil.Crickbuzz.Backend.entity.Player;
import com.swapnil.Crickbuzz.Backend.entity.Team;
import com.swapnil.Crickbuzz.Backend.repo.MatchRepository;
import com.swapnil.Crickbuzz.Backend.repo.PlayerRepository;
import com.swapnil.Crickbuzz.Backend.repo.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/test")
public class Test {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;

    public Test(TeamRepository teamRepository,
                PlayerRepository playerRepository,
                MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping
    public String addSampleData() {

        // ---------------- Teams ----------------
        Team india = new Team(0L, "India", "India", null);
        Team australia = new Team(0L, "Australia", "Australia", null);
        Team england = new Team(0L, "England", "England", null);
        Team southAfrica = new Team(0L, "South Africa", "South Africa", null);

        teamRepository.saveAll(List.of(india, australia, england, southAfrica));

        // ---------------- Players ----------------
        Player kohli = new Player(0L, india, "Batsman", "Virat Kohli");
        Player bumrah = new Player(0L, india, "Bowler", "Jasprit Bumrah");

        Player smith = new Player(0L, australia, "Batsman", "Steve Smith");
        Player cummins = new Player(0L, australia, "Bowler", "Pat Cummins");

        Player root = new Player(0L, england, "Batsman", "Joe Root");
        Player wood = new Player(0L, england, "Bowler", "Mark Wood");

        Player deKock = new Player(0L, southAfrica, "Batsman", "Quinton de Kock");
        Player rabada = new Player(0L, southAfrica, "Bowler", "Kagiso Rabada");

        playerRepository.saveAll(List.of(kohli, bumrah, smith, cummins, root, wood, deKock, rabada));

        // ---------------- Matches ----------------
        Match match1 = new Match(null, india, australia, LocalDate.of(2025,10,25),
                "Wankhede Stadium", 150, 145);

        Match match2 = new Match(null, india, australia, LocalDate.of(2025,11,1),
                "Eden Gardens", 210, 198);

        Match match3 = new Match(null, england, southAfrica, LocalDate.of(2025,11,3),
                "Lord's", 245, 240);

        Match match4 = new Match(null, southAfrica, england, LocalDate.of(2025,11,10),
                "Cape Town", 275, 260);

        matchRepository.saveAll(List.of(match1, match2, match3, match4));

        return "✅ Sample data inserted successfully (India–Australia + England–South Africa)!";
    }
}