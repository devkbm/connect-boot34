package com.like.cooperation.workcalendar.domain.port.in.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.workcalendar.domain.WorkCalendar;
import com.like.cooperation.workcalendar.domain.WorkCalendarEvent;
import com.like.cooperation.workcalendar.domain.port.in.WorkCalendarEventSaveUseCase;
import com.like.cooperation.workcalendar.domain.port.in.dto.WorkCalendarEventSaveDTO;
import com.like.cooperation.workcalendar.domain.port.out.WorkCalendarCommandDbPort;
import com.like.cooperation.workcalendar.domain.port.out.WorkCalendarEventCommandDbPort;

@Transactional
@Service
public class WorkCalendarEventSaveService implements WorkCalendarEventSaveUseCase {
	
	WorkCalendarEventCommandDbPort dbPort;
	WorkCalendarCommandDbPort calendarDbPort;
	
	WorkCalendarEventSaveService(WorkCalendarEventCommandDbPort dbPort,
								 WorkCalendarCommandDbPort calendarDbPort) {
		this.dbPort = dbPort;
		this.calendarDbPort = calendarDbPort;
	}
	
	@Override
	public void save(WorkCalendarEventSaveDTO dto) {
		WorkCalendar workGroup = calendarDbPort.select(dto.workCalendarId());
		WorkCalendarEvent entity = null; 
		
		if (dto.id() != null) {
			entity = dbPort.select(dto.id());
		}
		
		if (entity == null) {
			entity = dto.newSchedule(workGroup);
		} else {
			dto.modifySchedule(entity);
		}
		
		dbPort.save(entity);
	}

}
