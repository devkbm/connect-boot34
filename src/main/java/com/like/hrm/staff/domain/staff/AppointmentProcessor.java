package com.like.hrm.staff.domain.staff;

import com.like.hrm.hrmcode.application.dto.hrmcode.HrmCodeSelectDTO;
import com.like.hrm.hrmcode.application.port.in.hrmcode.HrmCodeSelectUseCase;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

public class AppointmentProcessor {
	
	HrmCodeSelectUseCase hrmCode;

	public void appoint(Staff staff, AppointmentRecord record) {
		HrmCodeSelectDTO appointmentCode = hrmCode.select("HR000", record.getAppointmentTypeCode());
		
		boolean isJoin = (boolean)appointmentCode.extraInfo().getOrDefault("joinDateYn", false);
		
		boolean isRetire = (boolean)appointmentCode.extraInfo().getOrDefault("retireDateYn", false);	
	}
}
