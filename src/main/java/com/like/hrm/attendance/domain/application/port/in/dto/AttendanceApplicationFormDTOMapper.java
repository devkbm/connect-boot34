package com.like.hrm.attendance.domain.application.port.in.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.like.common.vo.LocalDatePeriod;
import com.like.hrm.attendance.domain.application.AttendanceApplication;
import com.like.hrm.attendance.domain.application.port.in.dto.AttendanceApplicationFormDTO.DutyDate;
import com.like.system.holiday.domain.DateInfo;
import com.like.system.holiday.domain.DateInfoCollection;
import com.like.system.holiday.domain.port.in.DateInfoSelectUseCase;

public class AttendanceApplicationFormDTOMapper {

	public static AttendanceApplication newEntity(AttendanceApplicationFormDTO dto) {
		
		AttendanceApplication entity = new AttendanceApplication(
				dto.companyCode(),								  
		        dto.staffNo(),
		        dto.dutyCode(),
		        dto.dutyReason(),
		        new LocalDatePeriod(dto.fromDate(), dto.toDate()),
		        dto.selectedDate().stream().map(e -> e.date()).toList(),
		        dto.dutyTime()
		        );

		entity.setAppUrl(dto.clientAppUrl());

		return entity;		
	}
	
	public static void modify(AttendanceApplication entity, AttendanceApplicationFormDTO dto) {
		entity.modify(
				dto.dutyCode(),
				dto.dutyReason(),
				new LocalDatePeriod(dto.fromDate(), dto.toDate()),
				dto.selectedDate().stream().map(e -> e.date()).toList(),
				dto.dutyTime()
				);		

		entity.setAppUrl(dto.clientAppUrl());
	}
		
	
	public static AttendanceApplicationFormDTO toDTO(AttendanceApplication e, DateInfoSelectUseCase service) {
		if ( e == null ) return null;
		
		DateInfoCollection dateInfoList = service.select("001", e.getPeriod().getFrom(), e.getPeriod().getTo());
	
		return AttendanceApplicationFormDTO.builder()
				   .dutyId(e.getId())				   
				   .staffNo(e.getStaffNo())
				   .dutyCode(e.getDutyCode())
				   .dutyReason(e.getDutyReason())
				   .fromDate(e.getPeriod().getFrom())
				   .toDate(e.getPeriod().getTo())
				   .selectedDate(AttendanceApplicationFormDTOMapper.convertDutyDate(e, dateInfoList))
				   .dutyTime(e.getSumDutyTime())
				   .build();	
	}
	
	
	private static List<DutyDate> convertDutyDate(AttendanceApplication entity, DateInfoCollection dateInfoList) {
		List<DutyDate> dutyDatelist = new ArrayList<>(dateInfoList.size());
		List<LocalDate> selectedDate = entity.getSelectedDate();					
		
		for (DateInfo date : dateInfoList.getDates()) {							
			dutyDatelist.add(new DutyDate(date.getDate()										
										 ,selectedDate.contains(date.getDate())											 
										 ,date.isHoliday()
										 ,date.isHoliday()
										 ,date.isSunday()));
		}
		
		
		
		return dutyDatelist;
	}
}
