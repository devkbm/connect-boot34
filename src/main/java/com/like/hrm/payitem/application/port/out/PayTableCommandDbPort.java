package com.like.hrm.payitem.application.port.out;

import java.util.List;

import com.like.hrm.payitem.application.dto.PayTableDTO;
import com.like.hrm.payitem.domain.model.PayTable;

public interface PayTableCommandDbPort {
	
	List<PayTable> getPayTableList(PayTableDTO.SearchPayTable dto);
	
	PayTable getPayTable(Long id);
	
	void save(PayTable entity);
	
	void delete(PayTable entity);
}
