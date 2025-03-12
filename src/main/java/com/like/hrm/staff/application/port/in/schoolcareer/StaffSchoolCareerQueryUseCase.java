package com.like.hrm.staff.application.port.in.schoolcareer;

import java.util.List;

import com.like.hrm.staff.application.dto.schoolcareer.StaffSchoolCareerQueryResultDTO;

public interface StaffSchoolCareerQueryUseCase {
	List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo);
}
