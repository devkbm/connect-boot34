package com.like.hrm.workchangeapp.port.in;

import static org.springframework.util.StringUtils.hasText;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.like.common.vo.LocalDatePeriod;
import com.like.hrm.workchangeapp.domain.QWorkChangeApplication;
import com.like.hrm.workchangeapp.domain.WorkChangeApplication;
import com.like.system.holiday.domain.DateInfo;
import com.like.system.holiday.domain.DateInfoCollection;
import com.like.system.holiday.port.in.DateInfoSelectUseCase;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DutyApplicationDTO {

	public record Search(
			String staffId
			) {
		private static QWorkChangeApplication qDutyApplication = QWorkChangeApplication.workChangeApplication;
		
		public BooleanBuilder getBooleanBuilder() {
			BooleanBuilder builder = new BooleanBuilder();
			
			builder
				.and(eqStaffId(this.staffId));
			
			return builder;
		}
		
		private BooleanExpression eqStaffId(String staffId) {
			return hasText(staffId) ? qDutyApplication.staffId.eq(staffId) : null;					
		}
	}	
		
	@Builder(access = AccessLevel.PRIVATE)
	public static record Form(
			String clientAppUrl,
			String companyCode,
			Long dutyId,
			String staffId,
			String dutyCode,
			String dutyReason,
			LocalDate fromDate,
			LocalDate toDate,
			List<DutyDate> selectedDate,
			BigDecimal dutyTime) {
		
		public static Form convert(WorkChangeApplication e, DateInfoSelectUseCase service) {								
			DateInfoCollection dateInfoList = service.select("001", e.getPeriod().getFrom(), e.getPeriod().getTo());

			
			return Form.builder()
					   .dutyId(e.getId())
					   .staffId(e.getStaffId())
					   .dutyCode(e.getDutyCode())
					   .dutyReason(e.getDutyReason())
					   .fromDate(e.getPeriod().getFrom())
					   .toDate(e.getPeriod().getTo())
					   .selectedDate(Form.convertDutyDate(e, dateInfoList))
					   .dutyTime(e.getSumDutyTime())
					   .build();								  									  									  									
		}
		
		public WorkChangeApplication newEntity() {		
			
			WorkChangeApplication entity = new WorkChangeApplication(staffId								  
												        ,dutyCode
												        ,dutyReason
												        ,new LocalDatePeriod(fromDate, toDate)
												        ,this.getSelectedDate()
												        ,dutyTime);
			
			entity.setAppUrl(clientAppUrl);
			
			return entity;
			
		}
		
		public void modifyEntity(WorkChangeApplication entity) {
			entity.modifyEntity(dutyCode
							   ,dutyReason
							   ,new LocalDatePeriod(fromDate, toDate)
							   ,this.getSelectedDate()
							   ,dutyTime);		
			
			entity.setAppUrl(clientAppUrl);
		}			
		
		private List<LocalDate> getSelectedDate() {
			return selectedDate.stream().map(e -> e.date()).toList();
		}
		
		private static List<DutyDate> convertDutyDate(WorkChangeApplication entity, DateInfoCollection dateInfoList) {
			List<DutyDate> dutyDatelist = new ArrayList<>(dateInfoList.size());
			List<LocalDate> selectedDate = entity.getSelectedDate();					
			
			for (DateInfo date : dateInfoList.getDates()) {							
				dutyDatelist.add(new DutyDate(date.getDate()										
											 ,selectedDate.contains(date.getDate())											 
											 ,date.isHoliday()
											 ,date.isHoliday()
											 ,date.isSunday()));
			}
			
			log.info(dutyDatelist.toString());
			
			return dutyDatelist;
		}
	}		
	
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
