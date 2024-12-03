package com.like.hrm.hrmcode.port.in.hrmdependcode.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.hrmcode.adapter.out.db.HrmRelationCodeQueryRepository;
import com.like.hrm.hrmcode.port.in.hrmdependcode.dto.HrmRelationCodeDTO;

@Service
@Transactional(readOnly = true)
public class HrmRelationCodeQueryService {

	private HrmRelationCodeQueryRepository repository;
	
	public HrmRelationCodeQueryService(HrmRelationCodeQueryRepository repository) {
		this.repository = repository;
	}
	
	public List<?> getHrmRelationCodeList(HrmRelationCodeDTO.SearchHrmRelationCode condition) {
		return null;
		//return repository.getRelationCodeList(condition);
	}
}
