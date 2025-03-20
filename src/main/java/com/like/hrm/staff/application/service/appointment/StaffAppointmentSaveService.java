package com.like.hrm.staff.application.service.appointment;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.dto.appointment.StaffAppointmentRecordDTO;
import com.like.hrm.staff.application.port.in.appointment.StaffAppointmentSaveUseCase;
import com.like.hrm.staff.application.port.out.StaffAppointmentCommandDbPort;
import com.like.hrm.staff.application.port.out.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffAppointmentSaveService implements StaffAppointmentSaveUseCase {

	StaffCommandDbPort staffDbPort;
	StaffAppointmentCommandDbPort appointmentDbPort;
	
	StaffAppointmentSaveService(StaffCommandDbPort staffDbPort, StaffAppointmentCommandDbPort appointmentDbPort) {
		this.staffDbPort = staffDbPort;
		this.appointmentDbPort = appointmentDbPort;
	}
	
	@Override
	public void save(StaffAppointmentRecordDTO dto) {		
		
		Staff staff = staffDbPort.select(dto.companyCode(), dto.staffNo())
							.orElseThrow(() -> new EntityNotFoundException(dto.staffNo() + " 직원정보가 존재하지 않습니다."));		
		AppointmentRecord entity = staff.getAppointmentRecordList().get(staff, dto.seq());
		
		if (entity == null) {
			entity = dto.newEntity(staff);
		} else {
			dto.modifyEntity(entity);
		}
		
		staff.getAppointmentRecordList().add(entity);		
		staff.applyAppointmentRecord(entity);		 
		
		staffDbPort.save(staff);
		this.appointmentDbPort.save(entity);
		
	}
	
}
