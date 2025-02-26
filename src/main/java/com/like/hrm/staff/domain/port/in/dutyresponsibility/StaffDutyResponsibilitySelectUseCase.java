package com.like.hrm.staff.domain.port.in.dutyresponsibility;

import com.like.hrm.staff.domain.port.in.dutyresponsibility.dto.StaffDutyResponsibilityFormDTO;

public interface StaffDutyResponsibilitySelectUseCase {
	
	StaffDutyResponsibilityFormDTO select(String companyCode, String staffNo, Long seq);
}
