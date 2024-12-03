package com.like.hrm.workchangeapp.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.workchangeapp.adapter.out.db.jpa.DutyApplicationQueryRepository;
import com.like.hrm.workchangeapp.domain.WorkChangeApplication;
import com.like.hrm.workchangeapp.port.in.DutyApplicationDTO;

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
