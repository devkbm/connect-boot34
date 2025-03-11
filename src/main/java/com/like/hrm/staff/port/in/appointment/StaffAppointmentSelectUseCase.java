package com.like.hrm.staff.port.in.appointment;

import com.like.hrm.staff.port.dto.staff.appointment.StaffAppointmentRecordDTO;

public interface StaffAppointmentSelectUseCase {
	StaffAppointmentRecordDTO select(String companyCode, String staffNo, Long seq);	
}
