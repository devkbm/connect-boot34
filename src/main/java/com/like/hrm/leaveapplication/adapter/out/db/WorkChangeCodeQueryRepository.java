package com.like.hrm.leaveapplication.adapter.out.db;

import java.util.List;

import com.like.hrm.leaveapplication.domain.WorkChangeCode;
import com.like.hrm.leaveapplication.port.in.WorkChangeCodeDTO;

public interface WorkChangeCodeQueryRepository {
	List<WorkChangeCode> getDutyCodeList(WorkChangeCodeDTO.SearchDutyCode condition);
}
