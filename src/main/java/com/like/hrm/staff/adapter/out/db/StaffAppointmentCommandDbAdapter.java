package com.like.hrm.staff.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.data.StaffAppointmentJpaRepository;
import com.like.hrm.staff.application.port.out.StaffAppointmentCommandDbPort;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecordId;

@Repository
public class StaffAppointmentCommandDbAdapter implements StaffAppointmentCommandDbPort {
		
	StaffAppointmentJpaRepository repository;
	
	StaffAppointmentCommandDbAdapter(StaffAppointmentJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<AppointmentRecord> select(String companyCode, String staffNo, Long seq) {				
		return this.repository.findById(new AppointmentRecordId(companyCode, staffNo, seq));			
	}

	@Override
	public void save(AppointmentRecord entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(String companyCode, String staffNo, Long seq) {
		this.repository.deleteById(new AppointmentRecordId(companyCode, staffNo, seq));
		
	}	

}
