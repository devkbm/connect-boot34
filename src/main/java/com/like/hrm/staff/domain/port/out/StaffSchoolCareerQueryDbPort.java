package com.like.hrm.staff.domain.port.out;

import java.util.List;

import com.like.hrm.staff.domain.port.in.schoolcareer.dto.StaffSchoolCareerQueryResultDTO;

public interface StaffSchoolCareerQueryDbPort {
	List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo);
}
