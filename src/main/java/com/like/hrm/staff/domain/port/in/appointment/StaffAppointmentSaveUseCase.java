package com.like.hrm.staff.domain.port.in.appointment;

import com.like.hrm.staff.domain.port.in.appointment.dto.StaffAppointmentRecordDTO;

public interface StaffAppointmentSaveUseCase {
	void save(StaffAppointmentRecordDTO dto);	
}
