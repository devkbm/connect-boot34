package com.like.hrm.staff.application.port.in;

public interface StaffSelectUseCase {
	ResponseStaff select(String companyCode, String staffNo);
}
