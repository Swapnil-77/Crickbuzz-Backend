package com.swapnil.Crickbuzz.Backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;  // <-- add this line
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cricket_match")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // <-- add this line
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_a_id")
    private Team teamA;

    @ManyToOne
    @JoinColumn(name = "team_b_id")
    private Team teamB;

    private LocalDate matchDate;
    private String venue;
    private Integer scoreA;
    private Integer scoreB;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Team winner;

    private Integer margin;
    private String marginType;

    public Match() {}

    public Match(Long id, Team teamA, Team teamB, LocalDate matchDate, String venue, Integer scoreA, Integer scoreB) {
        this.id = id;
        this.teamA = teamA;
        this.teamB = teamB;
        this.matchDate = matchDate;
        this.venue = venue;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Team getTeamA() { return teamA; }
    public void setTeamA(Team teamA) { this.teamA = teamA; }

    public Team getTeamB() { return teamB; }
    public void setTeamB(Team teamB) { this.teamB = teamB; }

    public LocalDate getMatchDate() { return matchDate; }
    public void setMatchDate(LocalDate matchDate) { this.matchDate = matchDate; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public Integer getScoreA() { return scoreA; }
    public void setScoreA(Integer scoreA) { this.scoreA = scoreA; }

    public Integer getScoreB() { return scoreB; }
    public void setScoreB(Integer scoreB) { this.scoreB = scoreB; }

    public Team getWinner() { return winner; }
    public void setWinner(Team winner) { this.winner = winner; }

    public Integer getMargin() { return margin; }
    public void setMargin(Integer margin) { this.margin = margin; }

    public String getMarginType() { return marginType; }
    public void setMarginType(String marginType) { this.marginType = marginType; }

    @Transient
    public String getResult() {
        if (scoreA == null || scoreB == null) return "Match not yet played";
        if (scoreA > scoreB) return teamA.getName() + " won by " + (scoreA - scoreB) + " runs";
        if (scoreB > scoreA) return teamB.getName() + " won by " + (scoreB - scoreA) + " runs";
        return "Match tied";
    }
}
