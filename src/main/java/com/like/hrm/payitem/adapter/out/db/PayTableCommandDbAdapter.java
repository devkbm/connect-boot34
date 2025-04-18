package com.like.hrm.payitem.adapter.out.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.adapter.out.db.data.PayTableJpaRepository;
import com.like.hrm.payitem.application.dto.PayTableDTO.SearchPayTable;
import com.like.hrm.payitem.application.port.out.PayTableCommandDbPort;
import com.like.hrm.payitem.domain.model.PayTable;

@Repository
public class PayTableCommandDbAdapter implements PayTableCommandDbPort {

	private PayTableJpaRepository jpaPayTable;
	
	public PayTableCommandDbAdapter(PayTableJpaRepository jpaPayTable) {
		this.jpaPayTable = jpaPayTable;			
	}
	
	@Override
	public List<PayTable> getPayTableList(SearchPayTable dto) {
		Iterable<PayTable> result = jpaPayTable.findAll(dto.getBooleanBuilder());
		List<PayTable> list = new ArrayList<>();
		
		result.forEach(e -> list.add(e));
		
		return list;
	}
	
	@Override
	public PayTable getPayTable(Long id) {
		return this.jpaPayTable.findById(id).orElse(null);
	}

	@Override
	public void save(PayTable entity) {
		this.jpaPayTable.save(entity);		
	}

	@Override
	public void delete(PayTable entity) {
		this.jpaPayTable.delete(entity);		
	}

}
