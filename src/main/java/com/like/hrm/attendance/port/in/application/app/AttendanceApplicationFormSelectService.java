package com.like.hrm.attendance.port.in.application.app;

import org.springframework.stereotype.Service;

import com.like.hrm.attendance.port.in.application.AttendanceApplicationFormSelectUseCase;
import com.like.hrm.attendance.port.in.application.dto.AttendanceApplicationFormDTO;
import com.like.hrm.attendance.port.in.application.dto.AttendanceApplicationFormDTOMapper;
import com.like.hrm.attendance.port.out.application.AttendanceApplicationFormCommandDbPort;
import com.like.system.holiday.port.in.DateInfoSelectUseCase;

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
