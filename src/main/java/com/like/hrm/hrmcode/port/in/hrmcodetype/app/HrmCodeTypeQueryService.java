package com.like.hrm.hrmcode.port.in.hrmcodetype.app;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.hrm.hrmcode.port.in.hrmcodetype.HrmCodeTypeQueryUseCase;
import com.like.hrm.hrmcode.port.in.hrmcodetype.dto.HrmCodeTypeQueryDTO;
import com.like.hrm.hrmcode.port.in.hrmcodetype.dto.HrmCodeTypeSaveDTO;
import com.like.hrm.hrmcode.port.out.HrmCodeTypeQueryDbPort;

@Service
public class HrmCodeTypeQueryService implements HrmCodeTypeQueryUseCase {

	HrmCodeTypeQueryDbPort dbPort;
	
	HrmCodeTypeQueryService(HrmCodeTypeQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<HrmCodeTypeSaveDTO> select(HrmCodeTypeQueryDTO dto) {
		return this.dbPort.select(dto)
						  .stream()
						  .map(e -> HrmCodeTypeSaveDTO.toDTO(e))
						  .toList();
	}

}
