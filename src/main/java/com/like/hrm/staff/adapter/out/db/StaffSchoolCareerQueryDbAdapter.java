package com.like.hrm.staff.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.querydsl.StaffSchoolCareerQuerydsl;
import com.like.hrm.staff.domain.port.in.schoolcareer.dto.StaffSchoolCareerQueryResultDTO;
import com.like.hrm.staff.domain.port.out.StaffSchoolCareerQueryDbPort;

@Repository
public class StaffSchoolCareerQueryDbAdapter implements StaffSchoolCareerQueryDbPort {

	StaffSchoolCareerQuerydsl querydsl;
	
	StaffSchoolCareerQueryDbAdapter(StaffSchoolCareerQuerydsl querydsl) {
		this.querydsl = querydsl;
	}
	
	@Override
	public List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo) {
		return this.querydsl.select(companyCode, staffNo);
	}

}
