package com.like.hrm.staff.port.in.dutyresponsibility;

import com.like.hrm.staff.port.dto.staff.dutyresponsibility.StaffDutyResponsibilityFormDTO;

public interface StaffDutyResponsibilitySelectUseCase {
	
	StaffDutyResponsibilityFormDTO select(String companyCode, String staffNo, Long seq);
}
