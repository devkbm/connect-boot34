package com.like.hrm.staff.domain.staff;

import java.util.List;

import com.like.hrm.staff.application.dto.StaffQueryConditionDTO;
import com.like.hrm.staff.application.port.in.ResponseStaffAppointmentRecord;
import com.like.hrm.staff.application.port.in.ResponseStaffCurrentAppointment;
import com.like.hrm.staff.application.port.in.ResponseStaffDutyResponsibility;

public interface StaffQueryRepository {

	
	List<Staff> getStaffList(StaffQueryConditionDTO dto);
	
	ResponseStaffCurrentAppointment getStaffCurrentAppointment(String companyCode, String staffNo);
		
	List<ResponseStaffAppointmentRecord> getStaffAppointmentRecordList(String companyCode, String staffNo);
	
	List<ResponseStaffDutyResponsibility> getStaffDutyResponsibility(String companyCode, String staffNo);
	
}
