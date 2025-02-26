package com.like.hrm.staff.domain.port.in;

public interface StaffSelectUseCase {
	ResponseStaff select(String companyCode, String staffNo);
}
