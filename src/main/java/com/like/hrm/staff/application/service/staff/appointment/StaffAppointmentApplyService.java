package com.like.hrm.staff.application.service.staff.appointment;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.appointment.StaffAppointmentApplyUseCase;
import com.like.hrm.staff.application.port.out.StaffAppointmentCommandDbPort;
import com.like.hrm.staff.application.port.out.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffAppointmentApplyService implements StaffAppointmentApplyUseCase {

	StaffCommandDbPort staffDbPort;
	StaffAppointmentCommandDbPort appointmentDbPort;
	
	
	StaffAppointmentApplyService(StaffCommandDbPort staffDbPort, StaffAppointmentCommandDbPort appointmentDbPort) {
		this.staffDbPort = staffDbPort;
		this.appointmentDbPort = appointmentDbPort;
	}
	
	@Override
	public void apply(String companyCode, String staffNo, Long seq) {
		Staff staff = staffDbPort.select(companyCode, staffNo)
						    .orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원정보가 존재하지 않습니다."));
		
		AppointmentRecord entity = appointmentDbPort.select(companyCode, staffNo, seq)
				.orElseThrow(() -> new EntityNotFoundException(staffNo + " 발령정보가 존재하지 않습니다."));;
		
		staff.applyAppointmentRecord(entity);
		
		staffDbPort.save(staff);
		appointmentDbPort.save(entity);		
	}

}
