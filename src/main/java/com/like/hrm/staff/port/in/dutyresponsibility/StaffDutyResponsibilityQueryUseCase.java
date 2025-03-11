package com.like.hrm.staff.port.in.dutyresponsibility;

import java.util.List;

import com.like.hrm.staff.port.dto.staff.dutyresponsibility.StaffDutyResponsibilityQueryResultDTO;

public interface StaffDutyResponsibilityQueryUseCase {

	List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo);
}
