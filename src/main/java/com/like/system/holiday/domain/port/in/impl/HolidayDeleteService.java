package com.like.system.holiday.domain.port.in.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.like.system.holiday.domain.port.in.HolidayDeleteUseCase;
import com.like.system.holiday.domain.port.out.HolidayDeletePort;

@Service
public class HolidayDeleteService implements HolidayDeleteUseCase {

	HolidayDeletePort port;
	
	public HolidayDeleteService(HolidayDeletePort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, LocalDate date) {
		this.port.delete(companyCode, date);		
	}

}
