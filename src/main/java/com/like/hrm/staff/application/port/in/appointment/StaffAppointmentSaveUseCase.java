package com.like.hrm.staff.application.port.in.appointment;

import com.like.hrm.staff.application.dto.appointment.StaffAppointmentRecordDTO;

public interface StaffAppointmentSaveUseCase {
	void save(StaffAppointmentRecordDTO dto);	
}
