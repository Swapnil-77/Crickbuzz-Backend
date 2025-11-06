package com.swapnil.Crickbuzz.Backend.repo;

import com.swapnil.Crickbuzz.Backend.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
