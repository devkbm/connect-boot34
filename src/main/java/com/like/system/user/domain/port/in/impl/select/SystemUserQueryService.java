package com.like.system.user.domain.port.in.impl.select;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.user.domain.port.in.SystemUserQueryUseCase;
import com.like.system.user.domain.port.in.dto.SystemUserQueryDTO;
import com.like.system.user.domain.port.in.dto.SystemUserSelectDTO;
import com.like.system.user.domain.port.in.dto.SystemUserSelectDTOMapper;
import com.like.system.user.domain.port.out.SystemUserQueryDbPort;

@Transactional(readOnly = true)
@Service
public class SystemUserQueryService implements SystemUserQueryUseCase {

	SystemUserQueryDbPort dbPort;
	
	SystemUserQueryService(SystemUserQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<SystemUserSelectDTO> selectList(SystemUserQueryDTO dto) {
		return this.dbPort.selectList(dto)
						  .stream()
						  .map(e -> SystemUserSelectDTOMapper.toDTO(e, dto.companyCode()))
						  .toList();
	}

}
