package com.like.hrm.staff.domain.port.out;

import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

public interface StaffAppointmentSelectDbPort {
	AppointmentRecord select(String companyCode, String staffNo, Long seq);	
}
