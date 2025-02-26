package com.like.hrm.attendance.domain.application.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.attendance.domain.application.port.in.AttendanceApplicationFormSelectUseCase;
import com.like.hrm.attendance.domain.application.port.in.dto.AttendanceApplicationFormDTO;
import com.like.hrm.attendance.domain.application.port.in.dto.AttendanceApplicationFormDTOMapper;
import com.like.hrm.attendance.domain.application.port.out.AttendanceApplicationFormCommandDbPort;
import com.like.system.holiday.domain.port.in.DateInfoSelectUseCase;

@Service
public class AttendanceApplicationFormSelectService implements AttendanceApplicationFormSelectUseCase {

	AttendanceApplicationFormCommandDbPort dbPort;
	
	DateInfoSelectUseCase service;
	
	AttendanceApplicationFormSelectService(AttendanceApplicationFormCommandDbPort dbPort, DateInfoSelectUseCase service) {
		this.dbPort = dbPort;
		this.service = service;
	}
	
	@Override
	public AttendanceApplicationFormDTO select(Long id) {
		this.dbPort.select(id);
				
		return AttendanceApplicationFormDTOMapper.toDTO(this.dbPort.select(id).orElse(null), service);
	}

}
