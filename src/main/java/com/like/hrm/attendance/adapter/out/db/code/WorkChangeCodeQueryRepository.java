package com.like.hrm.attendance.adapter.out.db.code;

import java.util.List;

import com.like.hrm.attendance.domain.application.WorkChangeCode;
import com.like.hrm.attendance.port.in.code.dto.WorkChangeCodeDTO;

public interface WorkChangeCodeQueryRepository {
	List<WorkChangeCode> getDutyCodeList(WorkChangeCodeDTO.SearchDutyCode condition);
}
