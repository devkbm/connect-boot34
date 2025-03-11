package com.like.hrm.staff.port.in.schoolcareer;

import java.util.List;

import com.like.hrm.staff.port.dto.staff.schoolcareer.StaffSchoolCareerQueryResultDTO;

public interface StaffSchoolCareerQueryUseCase {
	List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo);
}
