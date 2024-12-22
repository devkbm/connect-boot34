package com.like.cooperation.workcalendar.port.in.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.workcalendar.port.in.WorkCalendarEventSelectUseCase;
import com.like.cooperation.workcalendar.port.in.dto.WorkCalendarEventResponseDTO;
import com.like.cooperation.workcalendar.port.out.WorkCalendarEventCommandDbPort;

@Transactional
@Service
public class WorkCalendarEventSelectService implements WorkCalendarEventSelectUseCase {

	WorkCalendarEventCommandDbPort dbPort;
	
	WorkCalendarEventSelectService(WorkCalendarEventCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public WorkCalendarEventResponseDTO select(Long id) {
		return WorkCalendarEventResponseDTO.toDTO(this.dbPort.select(id));
	}

}