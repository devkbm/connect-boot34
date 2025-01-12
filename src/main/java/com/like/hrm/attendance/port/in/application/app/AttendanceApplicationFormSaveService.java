package com.like.hrm.attendance.port.in.application.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.attendance.domain.application.AttendanceApplication;
import com.like.hrm.attendance.port.in.application.AttendanceApplicationFormSaveUseCase;
import com.like.hrm.attendance.port.in.application.dto.AttendanceApplicationFormDTO;
import com.like.hrm.attendance.port.in.application.dto.AttendanceApplicationFormDTOMapper;
import com.like.hrm.attendance.port.out.application.AttendanceApplicationFormCommandDbPort;

@Transactional
@Service
public class AttendanceApplicationFormSaveService implements AttendanceApplicationFormSaveUseCase {

	AttendanceApplicationFormCommandDbPort dbPort;
	
	AttendanceApplicationFormSaveService(AttendanceApplicationFormCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(AttendanceApplicationFormDTO dto) {
		AttendanceApplication entity = null;
		
		if (dto.dutyId() == null) {
			entity = AttendanceApplicationFormDTOMapper.newEntity(dto);
		} else {
			entity = this.dbPort.select(dto.dutyId()).orElse(null);
			
			AttendanceApplicationFormDTOMapper.modify(entity, dto);			
		}
		
		dbPort.save(entity);		
	}

}
