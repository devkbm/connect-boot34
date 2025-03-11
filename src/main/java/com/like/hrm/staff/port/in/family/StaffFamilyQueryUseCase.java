package com.like.hrm.staff.port.in.family;

import java.util.List;

import com.like.hrm.staff.port.dto.staff.family.StaffFamilyQueryResultDTO;

public interface StaffFamilyQueryUseCase {
	List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo);
}
