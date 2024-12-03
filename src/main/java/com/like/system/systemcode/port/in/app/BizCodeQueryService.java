package com.like.system.systemcode.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.systemcode.adapter.out.persistence.jpa.entity.JpaBizCode;
import com.like.system.systemcode.adapter.out.persistence.jpa.repository.BizCodeQueryRepository;

@Service
@Transactional(readOnly = true)
public class BizCodeQueryService {

	private BizCodeQueryRepository repository;
	
	public BizCodeQueryService(BizCodeQueryRepository repository) {
		this.repository = repository;
	}
	
	public List<JpaBizCode> getBizCodeAllList(String companyCode, String typeId) {
		return this.repository.getBizCodeList(companyCode, typeId);
	}
}
