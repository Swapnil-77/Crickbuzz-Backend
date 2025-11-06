package com.swapnil.Crickbuzz.Backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;  // <-- add this line
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String country;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonIgnore  // <-- add this line to stop infinite recursion
    private List<Player> players;

    public Team() {}

    public Team(long id, String name, String country, List<Player> players) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.players = players;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }
}
