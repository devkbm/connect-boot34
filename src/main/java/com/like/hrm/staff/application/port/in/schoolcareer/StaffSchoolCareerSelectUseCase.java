package com.like.hrm.staff.application.port.in.schoolcareer;

import com.like.hrm.staff.application.dto.schoolcareer.StaffSchoolCareerFormDTO;

public interface StaffSchoolCareerSelectUseCase {	
	StaffSchoolCareerFormDTO select(String companyCode, String staffNo, Long seq);
}
