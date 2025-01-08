package com.like.hrm.leaveapplication.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.leaveapplication.adapter.out.db.WorkChangeCodeQueryRepository;
import com.like.hrm.leaveapplication.domain.WorkChangeCode;
import com.like.hrm.leaveapplication.port.in.WorkChangeCodeDTO;

@Service
@Transactional(readOnly = true)
public class DutyCodeQueryService {

	private WorkChangeCodeQueryRepository repository;
	
	public DutyCodeQueryService(WorkChangeCodeQueryRepository dutyCodeRepository) {
		this.repository = dutyCodeRepository;
	}
	
	public List<WorkChangeCode> getDutyCodeList(WorkChangeCodeDTO.SearchDutyCode condition) {
		return this.repository.getDutyCodeList(condition);
	}
}
