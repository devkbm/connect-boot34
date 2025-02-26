package com.like.hrm.staff.domain.port.out;

import java.util.List;

import com.like.hrm.staff.domain.port.in.dutyresponsibility.dto.StaffDutyResponsibilityQueryResultDTO;

public interface StaffDutyResponsibilityQueryDbPort {
	List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo);
}
