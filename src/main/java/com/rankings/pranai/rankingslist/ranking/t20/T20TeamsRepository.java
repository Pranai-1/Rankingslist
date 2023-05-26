package com.rankings.pranai.rankingslist.ranking.t20;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface T20TeamsRepository extends JpaRepository<T20Teams, Integer> {
	public List<T20Teams> findByUsername(String username);

}
