package com.rankings.pranai.rankingslist.ranking.odi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OdiTeamsRepository extends JpaRepository<OdiTeams, Integer> {
	public List<OdiTeams> findByUsername(String username);

}
