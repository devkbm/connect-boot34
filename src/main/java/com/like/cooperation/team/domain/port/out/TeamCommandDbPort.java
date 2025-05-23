package com.like.cooperation.team.domain.port.out;

import com.like.cooperation.team.domain.Team;

public interface TeamCommandDbPort {
	Team select(Long teamId);
	
	void save(Team entity);
	
	void delete(Long teamId);
}
