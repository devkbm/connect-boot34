package com.like.hrm.staff.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.querydsl.StaffAppointmentQuerydsl;
import com.like.hrm.staff.application.dto.staff.appointment.StaffAppointmentQueryResultDTO;
import com.like.hrm.staff.application.port.out.StaffAppointmentQueryDbPort;

@Repository
public class StaffAppointmentQueryDbAdapter implements StaffAppointmentQueryDbPort {

	StaffAppointmentQuerydsl query;
	
	StaffAppointmentQueryDbAdapter(StaffAppointmentQuerydsl query) {
		this.query = query;
	}
	
	@Override
	public List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo) {
		return this.query.select(companyCode, staffNo);	
	}	

}
