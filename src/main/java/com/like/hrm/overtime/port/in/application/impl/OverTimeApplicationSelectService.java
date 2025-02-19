package com.like.hrm.overtime.port.in.application.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.overtime.port.in.application.OverTimeApplicationSelectUseCase;
import com.like.hrm.overtime.port.in.application.dto.OverTimeApplicationFormDTO;
import com.like.hrm.overtime.port.in.application.dto.OverTimeApplicationFormDTOMapper;
import com.like.hrm.overtime.port.out.application.OverTimeApplicationCommandDbPort;

@Service
public class OverTimeApplicationSelectService implements OverTimeApplicationSelectUseCase {

	OverTimeApplicationCommandDbPort dbPort;
	
	OverTimeApplicationSelectService(OverTimeApplicationCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public OverTimeApplicationFormDTO select(Long id) {
		
		return OverTimeApplicationFormDTOMapper.toDTO(this.dbPort.select(id).orElse(null));
	}

}
