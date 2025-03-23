package com.like.hrm.hrmcode.application.service.hrmcode;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.like.hrm.hrmcode.application.dto.hrmcode.HrmCodeSaveDTO;
import com.like.hrm.hrmcode.application.port.in.hrmcode.HrmCodeSelectUseCase;
import com.like.hrm.hrmcode.application.port.out.hrmcode.HrmCodeCommandDbPort;
import com.like.hrm.hrmcode.domain.HrmCode;
import com.like.hrm.hrmcode.domain.HrmCodeId;

@Service
public class HrmCodeSelectService implements HrmCodeSelectUseCase {

	HrmCodeCommandDbPort dbPort;
	
	HrmCodeSelectService(HrmCodeCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
		
	@Override
	public HrmCodeSaveDTO select(String type, String code) {	
		HrmCode entity = this.dbPort.select(new HrmCodeId(type, code)).orElse(null);
		
		try {
			return HrmCodeSaveDTO.toDTO(entity);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}

}
