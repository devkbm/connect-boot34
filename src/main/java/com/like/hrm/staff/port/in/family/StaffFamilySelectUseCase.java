package com.like.hrm.staff.port.in.family;

import com.like.hrm.staff.port.in.family.dto.StaffFamilySaveDTO;

public interface StaffFamilySelectUseCase {	
	StaffFamilySaveDTO select(String companyCode, String staffNo, Long seq);
}

