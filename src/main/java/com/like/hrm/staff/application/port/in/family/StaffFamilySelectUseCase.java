package com.like.hrm.staff.application.port.in.family;

import com.like.hrm.staff.application.dto.family.StaffFamilyFormDTO;

public interface StaffFamilySelectUseCase {	
	StaffFamilyFormDTO select(String companyCode, String staffNo, Long seq);
}

