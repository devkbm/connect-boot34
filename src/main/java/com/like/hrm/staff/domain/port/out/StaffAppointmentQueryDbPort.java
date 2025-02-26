package com.like.hrm.staff.domain.port.out;

import java.util.List;

import com.like.hrm.staff.domain.port.in.appointment.dto.StaffAppointmentQueryResultDTO;

public interface StaffAppointmentQueryDbPort {
	List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo);
}
