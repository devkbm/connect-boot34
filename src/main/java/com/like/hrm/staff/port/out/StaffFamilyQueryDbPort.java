package com.like.hrm.staff.port.out;

import java.util.List;

import com.like.hrm.staff.port.dto.staff.family.StaffFamilyQueryResultDTO;

public interface StaffFamilyQueryDbPort {
	List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo);
}
