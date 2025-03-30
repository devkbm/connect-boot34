package com.like.hrm.staff.domain.staff;

import java.time.LocalDate;

import com.like.core.jpa.domain.AbstractAuditEntity;

public abstract class AbstractStaff extends AbstractAuditEntity {

	StaffId id;
	
	StaffName name;
	
	ResidentRegistrationNumber residentRegistrationNumber;
	
	Boolean isStaff;
	
	String gender;
	
	LocalDate birthday;
	
	String workStateCode;
	
	String imagePath;
}
