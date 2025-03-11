package com.like.hrm.staff.port.out;

import java.util.List;

import com.like.hrm.staff.port.dto.staff.dutyresponsibility.StaffDutyResponsibilityQueryResultDTO;

public interface StaffDutyResponsibilityQueryDbPort {
	List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo);
}
