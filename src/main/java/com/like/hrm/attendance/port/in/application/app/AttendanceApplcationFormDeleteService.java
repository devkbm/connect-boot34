package com.like.hrm.attendance.port.in.application.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.attendance.port.in.application.AttendanceApplcationFormDeleteUseCase;
import com.like.hrm.attendance.port.out.application.AttendanceApplicationFormCommandDbPort;

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
