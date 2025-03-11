package com.like.hrm.staff.port.out;

import java.util.List;

import com.like.hrm.staff.port.dto.staff.appointment.StaffAppointmentQueryResultDTO;

public interface StaffAppointmentQueryDbPort {
	List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo);
}
