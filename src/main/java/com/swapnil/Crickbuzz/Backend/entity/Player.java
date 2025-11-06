package com.swapnil.Crickbuzz.Backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String role;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player() {}

    public Player(long id, Team team, String role, String name) {
        this.id = id;
        this.team = team;
        this.role = role;
        this.name = name;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
}
