package com.like.hrm.staff.port.out;

import java.util.List;

import com.like.hrm.staff.port.in.family.dto.StaffFamilyQueryResultDTO;

public interface StaffFamilyQueryDbPort {
	List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo);
}
