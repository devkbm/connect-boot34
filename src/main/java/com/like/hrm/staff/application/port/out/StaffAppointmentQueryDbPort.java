package com.like.hrm.staff.application.port.out;

import java.util.List;

import com.like.hrm.staff.application.dto.staff.appointment.StaffAppointmentQueryResultDTO;

public interface StaffAppointmentQueryDbPort {
	List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo);
}
