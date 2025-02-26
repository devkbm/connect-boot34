package com.like.system.dept.domain.port.in;

import com.like.system.dept.domain.port.in.dto.DeptSaveDTO;

public interface DeptSelectUseCase {
	DeptSaveDTO select(String companyCode, String deptCode);	
}
