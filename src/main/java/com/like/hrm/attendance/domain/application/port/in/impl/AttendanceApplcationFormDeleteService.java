package com.like.hrm.attendance.domain.application.port.in.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.attendance.domain.application.port.in.AttendanceApplcationFormDeleteUseCase;
import com.like.hrm.attendance.domain.application.port.out.AttendanceApplicationFormCommandDbPort;

@Transactional
@Service
public class AttendanceApplcationFormDeleteService implements AttendanceApplcationFormDeleteUseCase {

	AttendanceApplicationFormCommandDbPort dbPort;
	
	AttendanceApplcationFormDeleteService(AttendanceApplicationFormCommandDbPort dbPort) { 
		this.dbPort = dbPort;
	}

	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);		
	}
}
