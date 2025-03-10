package com.like.hrm.staff.domain.staff;

import java.util.List;

import com.like.hrm.staff.domain.port.in.ResponseStaffAppointmentRecord;
import com.like.hrm.staff.domain.port.in.ResponseStaffCurrentAppointment;
import com.like.hrm.staff.domain.port.in.ResponseStaffDutyResponsibility;
import com.like.hrm.staff.domain.port.in.dto.StaffQueryConditionDTO;

public interface StaffQueryRepository {

	
	List<Staff> getStaffList(StaffQueryConditionDTO dto);
	
	ResponseStaffCurrentAppointment getStaffCurrentAppointment(String companyCode, String staffNo);
		
	List<ResponseStaffAppointmentRecord> getStaffAppointmentRecordList(String companyCode, String staffNo);
	
	List<ResponseStaffDutyResponsibility> getStaffDutyResponsibility(String companyCode, String staffNo);
	
}
