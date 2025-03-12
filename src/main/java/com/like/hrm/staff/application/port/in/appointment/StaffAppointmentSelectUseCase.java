package com.like.hrm.staff.application.port.in.appointment;

import com.like.hrm.staff.application.dto.appointment.StaffAppointmentRecordDTO;

public interface StaffAppointmentSelectUseCase {
	StaffAppointmentRecordDTO select(String companyCode, String staffNo, Long seq);	
}
