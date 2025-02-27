package com.like.system.dept.domain.port.in.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.dept.domain.port.in.DeptQueryUseCase;
import com.like.system.dept.domain.port.in.dto.DeptQueryDTO;
import com.like.system.dept.domain.port.in.dto.DeptSaveDTO;
import com.like.system.dept.domain.port.in.dto.DeptSaveDTOMapper;
import com.like.system.dept.domain.port.out.DeptQueryDbPort;

@Transactional(readOnly = true)
@Service
public class DeptQueryService implements DeptQueryUseCase {

	DeptQueryDbPort port;
	
	DeptQueryService(DeptQueryDbPort port) {
		this.port = port;
	}
	
	@Override
	public List<DeptSaveDTO> select(DeptQueryDTO dto) {
		return this.port.select(dto)
						.stream()
						.map(e -> DeptSaveDTOMapper.toDTO(e))
						.toList();
	}
}
