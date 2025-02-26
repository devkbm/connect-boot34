package com.like.hrm.staff.domain.port.in.family;

import java.util.List;

import com.like.hrm.staff.domain.port.in.family.dto.StaffFamilyQueryResultDTO;

public interface StaffFamilyQueryUseCase {
	List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo);
}
