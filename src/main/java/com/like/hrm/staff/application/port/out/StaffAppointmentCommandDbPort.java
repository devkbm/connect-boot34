package com.like.hrm.staff.application.port.out;

import java.util.Optional;

import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

public interface StaffAppointmentCommandDbPort {
	Optional<AppointmentRecord> select(String companyCode, String staffNo, Long seq);	

	void save(AppointmentRecord entity);
	
	void delete(String companyCode, String staffNo, Long seq);
}
