package com.like.hrm.staff.port.in.appointment;

import java.util.List;

import com.like.hrm.staff.port.in.appointment.dto.StaffAppointmentQueryResultDTO;

public interface StaffAppointmentQueryUseCase {
	List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo);
}
