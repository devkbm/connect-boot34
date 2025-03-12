package com.like.hrm.staff.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.querydsl.StaffDutyResponsibilityQuerydsl;
import com.like.hrm.staff.application.dto.dutyresponsibility.StaffDutyResponsibilityQueryResultDTO;
import com.like.hrm.staff.application.port.out.StaffDutyResponsibilityQueryDbPort;

@Repository
public class StaffDutyResponsibilityQueryDbAdapter implements StaffDutyResponsibilityQueryDbPort {

	StaffDutyResponsibilityQuerydsl querydsl;
	
	StaffDutyResponsibilityQueryDbAdapter(StaffDutyResponsibilityQuerydsl querydsl) {
		this.querydsl = querydsl;
	}
	
	@Override
	public List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo) {
		return querydsl.select(companyCode, staffNo);
	}

}
