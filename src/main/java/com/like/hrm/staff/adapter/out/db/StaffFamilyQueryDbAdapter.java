package com.like.hrm.staff.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.querydsl.StaffFamilyQuerydsl;
import com.like.hrm.staff.port.in.family.dto.StaffFamilyQueryResultDTO;
import com.like.hrm.staff.port.out.StaffFamilyQueryDbPort;

@Repository
public class StaffFamilyQueryDbAdapter implements StaffFamilyQueryDbPort {

	StaffFamilyQuerydsl querydsl;
	
	StaffFamilyQueryDbAdapter(StaffFamilyQuerydsl querydsl) {
		this.querydsl = querydsl;
	}
	
	@Override
	public List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo) { 
		return querydsl.select(companyCode, staffNo);
	}

}
