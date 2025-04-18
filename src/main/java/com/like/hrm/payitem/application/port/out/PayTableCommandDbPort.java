package com.like.hrm.payitem.application.port.out;

import com.like.hrm.payitem.domain.PayTable;

public interface PayTableCommandDbPort {	
	
	PayTable getPayTable(Long id);
	
	void save(PayTable entity);
	
	void delete(PayTable entity);
}
