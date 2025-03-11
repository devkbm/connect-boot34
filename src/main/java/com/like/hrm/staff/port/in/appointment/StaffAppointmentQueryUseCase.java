package com.like.hrm.staff.port.in.appointment;

import java.util.List;

import com.like.hrm.staff.port.dto.staff.appointment.StaffAppointmentQueryResultDTO;

public interface StaffAppointmentQueryUseCase {
	List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo);
}
