package com.like.hrm.staff.application.port.out;

import java.util.List;

import com.like.hrm.staff.application.dto.family.StaffFamilyQueryResultDTO;

public interface StaffFamilyQueryDbPort {
	List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo);
}
