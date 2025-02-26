package com.like.hrm.staff.domain.port.in.appointment;

public interface StaffAppointmentApplyUseCase {
	void apply(String companyCode, String staffNo, Long seq);
}
