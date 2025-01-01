package com.like.hrm.staff.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.querydsl.StaffLicenseQuerydsl;
import com.like.hrm.staff.port.in.license.dto.StaffLicenseQueryResultDTO;
import com.like.hrm.staff.port.out.StaffLicenseQueryDbPort;

@Repository
public class StaffLicenseQueryDbAdapter implements StaffLicenseQueryDbPort {

	StaffLicenseQuerydsl querydsl;
	
	StaffLicenseQueryDbAdapter(StaffLicenseQuerydsl querydsl) {
		this.querydsl = querydsl;
	}
	
	@Override
	public List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo) {
		return querydsl.select(companyCode, staffNo);
	}

}
