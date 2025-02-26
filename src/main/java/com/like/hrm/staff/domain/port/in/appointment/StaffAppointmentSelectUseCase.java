package com.like.hrm.staff.domain.port.in.appointment;

import com.like.hrm.staff.domain.port.in.appointment.dto.StaffAppointmentRecordDTO;

public interface StaffAppointmentSelectUseCase {
	StaffAppointmentRecordDTO select(String companyCode, String staffNo, Long seq);	
}
