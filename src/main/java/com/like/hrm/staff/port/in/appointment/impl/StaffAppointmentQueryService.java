package com.like.hrm.staff.port.in.appointment.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.port.dto.staff.appointment.StaffAppointmentQueryResultDTO;
import com.like.hrm.staff.port.in.appointment.StaffAppointmentQueryUseCase;
import com.like.hrm.staff.port.out.StaffAppointmentQueryDbPort;

@Transactional(readOnly = true)
@Service
public class StaffAppointmentQueryService implements StaffAppointmentQueryUseCase {
	
	StaffAppointmentQueryDbPort dbPort;
	
	StaffAppointmentQueryService(StaffAppointmentQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo) {
		
		return this.dbPort.select(companyCode, staffNo);
	}
}
