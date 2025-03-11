package com.like.hrm.staff.port.in.family;

import com.like.hrm.staff.port.dto.staff.family.StaffFamilyFormDTO;

public interface StaffFamilySelectUseCase {	
	StaffFamilyFormDTO select(String companyCode, String staffNo, Long seq);
}

