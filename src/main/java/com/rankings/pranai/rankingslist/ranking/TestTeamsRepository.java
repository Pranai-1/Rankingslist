package com.rankings.pranai.rankingslist.ranking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TestTeamsRepository extends JpaRepository<TestTeams, Integer> {

	public List<TestTeams> findByUsername(String username);

}
