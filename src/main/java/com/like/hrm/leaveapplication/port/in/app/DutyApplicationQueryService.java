package com.like.hrm.leaveapplication.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.leaveapplication.adapter.out.db.DutyApplicationQueryRepository;
import com.like.hrm.leaveapplication.domain.WorkChangeApplication;
import com.like.hrm.leaveapplication.port.in.DutyApplicationDTO;

@Service
@Transactional(readOnly = true)
public class DutyApplicationQueryService {

	private DutyApplicationQueryRepository repository;
	
	public DutyApplicationQueryService(DutyApplicationQueryRepository repository) {
		this.repository = repository;
	}
	
	public List<WorkChangeApplication> getDutyApplicationList(DutyApplicationDTO.Search condition) {
		return this.repository.getDutyApplicationList(condition);
	}
}
