package com.like.system.dept.domain.port.in;

import java.util.List;

import com.like.system.dept.domain.port.in.dto.DeptQueryDTO;
import com.like.system.dept.domain.port.in.dto.DeptSaveDTO;

public interface DeptQueryUseCase {
	List<DeptSaveDTO> select(DeptQueryDTO dto);
}
