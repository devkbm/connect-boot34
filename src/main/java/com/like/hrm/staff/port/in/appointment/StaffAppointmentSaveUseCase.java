package com.like.hrm.staff.port.in.appointment;

import com.like.hrm.staff.port.dto.staff.appointment.StaffAppointmentRecordDTO;

public interface StaffAppointmentSaveUseCase {
	void save(StaffAppointmentRecordDTO dto);	
}
