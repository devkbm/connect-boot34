package com.like.hrm.staff.domain.port.in.dutyresponsibility;

import java.util.List;

import com.like.hrm.staff.domain.port.in.dutyresponsibility.dto.StaffDutyResponsibilityQueryResultDTO;

public interface StaffDutyResponsibilityQueryUseCase {

	List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo);
}
