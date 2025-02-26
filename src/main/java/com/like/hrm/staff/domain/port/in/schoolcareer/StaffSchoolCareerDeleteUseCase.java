package com.like.hrm.staff.domain.port.in.schoolcareer;

public interface StaffSchoolCareerDeleteUseCase {
	void delete(String companyCode, String staffNo, Long seq);
}
