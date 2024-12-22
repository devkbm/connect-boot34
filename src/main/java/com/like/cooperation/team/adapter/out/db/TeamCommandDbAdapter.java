package com.like.cooperation.team.adapter.out.db;

import org.springframework.stereotype.Repository;

import com.like.cooperation.team.adapter.out.db.jpa.TeamJpaRepository;
import com.like.cooperation.team.domain.Team;
import com.like.cooperation.team.port.out.TeamCommandDbPort;

@Repository
public class TeamCommandDbAdapter implements TeamCommandDbPort {

	TeamJpaRepository repository;
	
	TeamCommandDbAdapter(TeamJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Team select(Long teamId) {
		return this.repository.findById(teamId).orElse(null);
	}

	@Override
	public void save(Team entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(Long teamId) {
		this.repository.deleteById(teamId);
	}

}