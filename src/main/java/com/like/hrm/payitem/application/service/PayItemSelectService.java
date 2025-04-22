package com.like.hrm.payitem.application.service;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.dto.PayItemFormDTO;
import com.like.hrm.payitem.application.dto.PayItemFormDTOMapper;
import com.like.hrm.payitem.application.port.in.PayItemSelectUseCase;
import com.like.hrm.payitem.application.port.out.PayItemCommandDbPort;
import com.like.hrm.payitem.domain.PayItemId;

@Service
public class PayItemSelectService implements PayItemSelectUseCase {

	PayItemCommandDbPort dbPort;
	
	PayItemSelectService(PayItemCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public PayItemFormDTO select(String companyCode, String itemCode) {		
		return PayItemFormDTOMapper.toDTO(
				this.dbPort.select(new PayItemId(companyCode, itemCode)).orElse(null)
				);
	}
	
	
	
}
