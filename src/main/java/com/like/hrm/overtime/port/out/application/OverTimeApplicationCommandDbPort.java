package com.like.hrm.overtime.port.out.application;

import java.util.Optional;

import com.like.hrm.overtime.domain.application.OverTimeApplication;

public interface OverTimeApplicationCommandDbPort {

	Optional<OverTimeApplication> select(Long id);
	
	void save(OverTimeApplication entity);
	
	void delete(Long id);
}
