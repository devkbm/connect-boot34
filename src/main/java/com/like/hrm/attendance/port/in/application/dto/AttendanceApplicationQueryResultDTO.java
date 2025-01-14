package com.like.hrm.attendance.port.in.application.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceApplicationQueryResultDTO {

	Long id;	
	String staffNo;
	String staffName;
	String dutyCode;
	String dutyName;
	String dutyReason;
	LocalDate fromDate;
	LocalDate toDate;

}
