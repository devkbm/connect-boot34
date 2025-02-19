package com.like.hrm.overtime.port.in.application.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.overtime.port.in.application.OverTimeApplicationDeleteUseCase;
import com.like.hrm.overtime.port.out.application.OverTimeApplicationCommandDbPort;

@Service
public class OverTimeApplicationDeleteService implements OverTimeApplicationDeleteUseCase {

	OverTimeApplicationCommandDbPort dbPort;
	
	OverTimeApplicationDeleteService(OverTimeApplicationCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);		
	}

}
