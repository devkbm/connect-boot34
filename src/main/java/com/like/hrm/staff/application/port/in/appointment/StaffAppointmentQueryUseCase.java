package com.like.hrm.staff.application.port.in.appointment;

import java.util.List;

import com.like.hrm.staff.application.dto.appointment.StaffAppointmentQueryResultDTO;

public interface StaffAppointmentQueryUseCase {
	List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo);
}
