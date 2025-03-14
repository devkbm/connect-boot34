package com.like.hrm.staff.domain.staff;

import java.util.List;

import com.like.hrm.staff.application.dto.ResponseStaffAppointmentRecord;
import com.like.hrm.staff.application.dto.ResponseStaffCurrentAppointment;
import com.like.hrm.staff.application.dto.ResponseStaffDutyResponsibility;
import com.like.hrm.staff.application.dto.StaffQueryConditionDTO;

public interface StaffQueryRepository {

	
	List<Staff> getStaffList(StaffQueryConditionDTO dto);
	
	ResponseStaffCurrentAppointment getStaffCurrentAppointment(String companyCode, String staffNo);
		
	List<ResponseStaffAppointmentRecord> getStaffAppointmentRecordList(String companyCode, String staffNo);
	
	List<ResponseStaffDutyResponsibility> getStaffDutyResponsibility(String companyCode, String staffNo);
	
}
