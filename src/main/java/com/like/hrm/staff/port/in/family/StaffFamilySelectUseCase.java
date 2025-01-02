package com.like.hrm.staff.port.in.family;

import com.like.hrm.staff.port.in.family.dto.StaffFamilyFormDTO;

public interface StaffFamilySelectUseCase {	
	StaffFamilyFormDTO select(String companyCode, String staffNo, Long seq);
}

