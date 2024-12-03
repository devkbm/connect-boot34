package com.like.hrm.payitem.infra.jparepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.boundary.PayTableDTO.SearchPayTable;
import com.like.hrm.payitem.domain.model.PayTable;
import com.like.hrm.payitem.domain.repository.PayTableRepository;
import com.like.hrm.payitem.infra.jparepository.springdata.JpaPayTable;

@Repository
public class PayTableJpaRepository implements PayTableRepository {

	private JpaPayTable jpaPayTable;
	
	public PayTableJpaRepository(JpaPayTable jpaPayTable) {
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
