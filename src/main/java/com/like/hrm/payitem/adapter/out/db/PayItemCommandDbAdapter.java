package com.like.hrm.payitem.adapter.out.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.adapter.out.db.data.PayJpaRepository;
import com.like.hrm.payitem.application.dto.PayItemDTO.SearchPayItem;
import com.like.hrm.payitem.application.port.out.PayItemCommandDbPort;
import com.like.hrm.payitem.domain.model.PayItem;

@Repository
public class PayItemCommandDbAdapter implements PayItemCommandDbPort {

	private PayJpaRepository jpaPayItem;
	
	public PayItemCommandDbAdapter(PayJpaRepository jpaPayItem) {
		this.jpaPayItem = jpaPayItem;		
	}
	
	@Override
	public PayItem getPayItem(String code) {
		return this.jpaPayItem.findById(code).orElse(null);
	}

	@Override
	public void save(PayItem entity) {
		this.jpaPayItem.save(entity);
	}

	@Override
	public void delete(PayItem entity) {
		this.jpaPayItem.delete(entity);
	}

	@Override
	public List<PayItem> getPayItemList(SearchPayItem condition) {
		Iterable<PayItem> result = jpaPayItem.findAll(condition.getBooleanBuilder());
		List<PayItem> list = new ArrayList<>();
		
		result.forEach(e -> list.add(e));
		
		return list;
	}

}
