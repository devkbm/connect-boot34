package com.like.hrm.attendance.adapter.out.db.code;

import java.util.List;

import com.like.hrm.attendance.domain.code.WorkChangeCode;
import com.like.hrm.attendance.domain.code.port.in.dto.WorkChangeCodeDTO;

public interface WorkChangeCodeQueryRepository {
	List<WorkChangeCode> getDutyCodeList(WorkChangeCodeDTO.SearchDutyCode condition);
}
