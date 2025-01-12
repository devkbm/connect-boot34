package com.like.hrm.attendance.adapter.out.db.application;

import java.time.LocalDate;
import java.util.List;

import com.like.hrm.attendance.domain.application.AttendanceApplication;
import com.like.hrm.attendance.domain.application.WorkChangeCode;
import com.like.hrm.attendance.port.in.application.dto.DutyApplicationDTO;

public interface DutyApplicationQueryRepository {

	long getDutyApplicationCount(String staffId, List<WorkChangeCode> dutyCodeList, LocalDate fromDate, LocalDate toDate);
	
	List<AttendanceApplication> getDutyApplicationList(DutyApplicationDTO.Search condition);
}
