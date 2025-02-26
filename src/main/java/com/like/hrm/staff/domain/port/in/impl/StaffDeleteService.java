package com.like.hrm.staff.domain.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.port.in.StaffDeleteUseCase;
import com.like.hrm.staff.domain.port.out.StaffCommandDbPort;

@Service
public class StaffDeleteService implements StaffDeleteUseCase {

	StaffCommandDbPort dbPort;
	
	StaffDeleteService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(String companyCode, String id) {
		this.dbPort.delete(companyCode, id);		
	}

}
