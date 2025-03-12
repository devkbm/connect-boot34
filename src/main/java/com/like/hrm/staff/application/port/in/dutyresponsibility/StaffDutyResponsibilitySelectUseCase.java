package com.like.hrm.staff.application.port.in.dutyresponsibility;

import com.like.hrm.staff.application.dto.dutyresponsibility.StaffDutyResponsibilityFormDTO;

public interface StaffDutyResponsibilitySelectUseCase {
	
	StaffDutyResponsibilityFormDTO select(String companyCode, String staffNo, Long seq);
}
