package com.like.cooperation.workcalendar.domain.port.in.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.workcalendar.domain.port.in.WorkCalendarEventDeleteUseCase;
import com.like.cooperation.workcalendar.domain.port.out.WorkCalendarEventCommandDbPort;

@Transactional
@Service
public class WorkCalendarEventDeleteService implements WorkCalendarEventDeleteUseCase {

	WorkCalendarEventCommandDbPort dbPort;
	
	WorkCalendarEventDeleteService(WorkCalendarEventCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);
	}

}
