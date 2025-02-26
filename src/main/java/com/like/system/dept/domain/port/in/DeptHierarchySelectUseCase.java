package com.like.system.dept.domain.port.in;

import java.util.List;

import com.like.system.dept.domain.port.in.dto.DeptQueryDTO;

public interface DeptHierarchySelectUseCase {
	List<?> select(DeptQueryDTO dto);
}
