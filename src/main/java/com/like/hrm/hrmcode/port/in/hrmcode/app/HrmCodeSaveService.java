
package com.like.hrm.hrmcode.port.in.hrmcode.app;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.stereotype.Service;

import com.like.hrm.hrmcode.domain.HrmCode;
import com.like.hrm.hrmcode.domain.HrmCodeId;
import com.like.hrm.hrmcode.port.in.hrmcode.HrmCodeSaveUseCase;
import com.like.hrm.hrmcode.port.in.hrmcode.dto.HrmCodeSaveDTO;
import com.like.hrm.hrmcode.port.out.HrmCodeCommandDbPort;

@Service
public class HrmCodeSaveService implements HrmCodeSaveUseCase {

	HrmCodeCommandDbPort dbPort;
	
	HrmCodeSaveService(HrmCodeCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(HrmCodeSaveDTO dto) {
		HrmCode entity = null;
		
		if (hasText(dto.typeId()) && hasText(dto.code())) {
			entity = this.dbPort.select(new HrmCodeId(dto.typeId(), dto.code())).orElse(null);
		}
			
		if (entity == null) {
			entity = dto.newEntity();
		} else {
			entity = dto.modify(entity);
		}
		
		dbPort.save(entity);		
	}
 
}
