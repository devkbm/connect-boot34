package com.like.hrm.staff.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.domain.StaffQueryRepository;
import com.like.hrm.staff.port.in.ResponseStaffAppointmentRecord;
import com.like.hrm.staff.port.in.ResponseStaffCurrentAppointment;
import com.like.hrm.staff.port.in.ResponseStaffDutyResponsibility;
import com.like.hrm.staff.port.in.StaffQueryConditionDTO;

@Service
@Transactional(readOnly = true)
public class StaffQueryService {

	private StaffQueryRepository repository;
	
	public StaffQueryService(StaffQueryRepository repository) {
		this.repository = repository;		
	}
	
	public List<Staff> getStaff(StaffQueryConditionDTO dto) {
		return repository.getStaffList(dto);
	}
	
	public List<ResponseStaffAppointmentRecord> getStaffAppointmentRecordList(String companyCode, String staffNo) {
		return repository.getStaffAppointmentRecordList(companyCode, staffNo);
	}
	
	public ResponseStaffCurrentAppointment getStaffCurrentAppointment(String companyCode, String staffNo) {
		return repository.getStaffCurrentAppointment(companyCode, staffNo);
	}
	
	public List<ResponseStaffDutyResponsibility> getStaffDutyResponsibility(String companyCode, String staffNo) {
		return repository.getStaffDutyResponsibility(companyCode, staffNo);
	}
}
