package com.like.hrm.payitem.application.port.out;

import com.like.hrm.payitem.domain.PayItem;

public interface PayItemCommandDbPort {
	
	PayItem getPayItem(String code);
	
	void save(PayItem entity);
	
	void delete(PayItem entity);	
}
