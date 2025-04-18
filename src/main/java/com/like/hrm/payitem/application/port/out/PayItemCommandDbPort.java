package com.like.hrm.payitem.application.port.out;

import java.util.List;

import com.like.hrm.payitem.application.dto.PayItemDTO;
import com.like.hrm.payitem.domain.model.PayItem;

public interface PayItemCommandDbPort {

	List<PayItem> getPayItemList(PayItemDTO.SearchPayItem condition);
	
	PayItem getPayItem(String code);
	
	void save(PayItem entity);
	
	void delete(PayItem entity);	
}
