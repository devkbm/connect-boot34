package com.like.hrm.attendance.port.in.application.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.like.system.holiday.domain.DateInfo;
import com.like.system.holiday.domain.DateInfoCollection;

import lombok.Builder;

@Builder
public record AttendanceApplicationFormDTO(
		String clientAppUrl,
		String companyCode,
		String staffNo,
		Long dutyId,		
		String dutyCode,
		String dutyReason,
		LocalDate fromDate,
		LocalDate toDate,
		List<DutyDate> selectedDate,
		BigDecimal dutyTime
		) {
	
	public record DutyDate(
			LocalDate date,
			@JsonProperty("isSelected")boolean isSelected,
			@JsonProperty("isHoliday")boolean isHoliday,
			@JsonProperty("isSaturday")boolean isSaturday,
			@JsonProperty("isSunday")boolean isSunday
			) {
		
		public static List<DutyDate> convertInitDutyDateList(DateInfoCollection dateInfoList) {
			List<DutyDate> dutyDatelist = new ArrayList<>(dateInfoList.size());
			
			for (DateInfo date : dateInfoList.getDates()) {								
				if (date.isWeekend() || date.isHoliday() ) {
					dutyDatelist.add(new DutyDate(date.getDate(), false, date.isHoliday(), date.isHoliday(), date.isSunday()));
				} else {
					dutyDatelist.add(new DutyDate(date.getDate(), true, date.isHoliday(), date.isHoliday(), date.isSunday()));
				}				
			}					
			
			return dutyDatelist;
		}
	}
		
}
