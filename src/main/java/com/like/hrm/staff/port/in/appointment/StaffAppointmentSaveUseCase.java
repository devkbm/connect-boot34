package com.like.hrm.staff.port.in.appointment;

import com.like.hrm.staff.port.in.appointment.dto.StaffAppointmentRecordDTO;

public interface StaffAppointmentSaveUseCase {
	void save(StaffAppointmentRecordDTO dto);	
}
