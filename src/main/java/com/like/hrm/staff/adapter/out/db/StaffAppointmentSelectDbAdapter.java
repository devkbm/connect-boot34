package com.like.hrm.staff.adapter.out.db;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.data.StaffJpaRepository;
import com.like.hrm.staff.domain.port.out.StaffAppointmentSelectDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.StaffId;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

import jakarta.persistence.EntityNotFoundException;

@Repository
public class StaffAppointmentSelectDbAdapter implements StaffAppointmentSelectDbPort {
	
	StaffJpaRepository repository;
	
	StaffAppointmentSelectDbAdapter(StaffJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public AppointmentRecord select(String companyCode, String staffNo, Long seq) {
		Staff staff = repository.findById(new StaffId(companyCode, staffNo))
				 				.orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원번호가 존재하지 않습니다."));
				
		return staff.getAppointmentRecordList().get(staff, seq);			
	}	

}
