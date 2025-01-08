package com.like.hrm.leaveapplication.adapter.out.db;

import java.time.LocalDate;
import java.util.List;

import com.like.hrm.leaveapplication.domain.WorkChangeApplication;
import com.like.hrm.leaveapplication.domain.WorkChangeCode;
import com.like.hrm.leaveapplication.port.in.DutyApplicationDTO;

public interface DutyApplicationQueryRepository {

	long getDutyApplicationCount(String staffId, List<WorkChangeCode> dutyCodeList, LocalDate fromDate, LocalDate toDate);
	
	List<WorkChangeApplication> getDutyApplicationList(DutyApplicationDTO.Search condition);
}
