package com.like.hrm.staff.port.in.schoolcareer;

import com.like.hrm.staff.port.in.schoolcareer.dto.StaffSchoolCareerFormDTO;

public interface StaffSchoolCareerSelectUseCase {	
	StaffSchoolCareerFormDTO select(String companyCode, String staffNo, Long seq);
}
