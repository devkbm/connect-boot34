package com.like.cooperation.workcalendar.domain.port.in.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.workcalendar.domain.port.in.WorkCalendarDeleteUseCase;
import com.like.cooperation.workcalendar.domain.port.out.WorkCalendarCommandDbPort;

@Transactional
@Service
public class WorkCalendarDeleteService implements WorkCalendarDeleteUseCase {

	WorkCalendarCommandDbPort dbPort;
	
	WorkCalendarDeleteService(WorkCalendarCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);		
	}

}
