package com.like.hrm.staff.application.port.in.dutyresponsibility;

import java.util.List;

import com.like.hrm.staff.application.dto.dutyresponsibility.StaffDutyResponsibilityQueryResultDTO;

public interface StaffDutyResponsibilityQueryUseCase {

	List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo);
}
