package com.swapnil.Crickbuzz.Backend.repo;

import com.swapnil.Crickbuzz.Backend.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    // ✅ Query to find matches between two specific teams (both directions)
    @Query("SELECT m FROM Match m WHERE " +
            "(m.teamA.id = :teamAId AND m.teamB.id = :teamBId) " +
            "OR (m.teamA.id = :teamBId AND m.teamB.id = :teamAId)")
    List<Match> findMatchesBetweenTeams(@Param("teamAId") Long teamAId,
                                        @Param("teamBId") Long teamBId);

    // ✅ Find matches played by a single team (either as teamA or teamB)
    List<Match> findByTeamA_IdOrTeamB_Id(Long teamAId, Long teamBId);
}
