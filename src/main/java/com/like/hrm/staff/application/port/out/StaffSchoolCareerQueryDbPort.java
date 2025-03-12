package com.like.hrm.staff.application.port.out;

import java.util.List;

import com.like.hrm.staff.application.dto.schoolcareer.StaffSchoolCareerQueryResultDTO;

public interface StaffSchoolCareerQueryDbPort {
	List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo);
}
