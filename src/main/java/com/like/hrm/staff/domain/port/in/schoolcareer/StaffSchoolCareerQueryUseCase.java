package com.like.hrm.staff.domain.port.in.schoolcareer;

import java.util.List;

import com.like.hrm.staff.domain.port.in.schoolcareer.dto.StaffSchoolCareerQueryResultDTO;

public interface StaffSchoolCareerQueryUseCase {
	List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo);
}
