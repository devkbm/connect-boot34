package com.like.hrm.staff.domain.port.in.family;

public interface StaffFamilyDeleteUseCase {
	void delete(String companyCode, String staffNo, Long seq);
}
