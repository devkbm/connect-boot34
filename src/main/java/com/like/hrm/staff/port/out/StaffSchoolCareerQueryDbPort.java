package com.like.hrm.staff.port.out;

import java.util.List;

import com.like.hrm.staff.port.dto.staff.schoolcareer.StaffSchoolCareerQueryResultDTO;

public interface StaffSchoolCareerQueryDbPort {
	List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo);
}
