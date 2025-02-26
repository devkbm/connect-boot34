package com.like.system.dept.domain.port.out;

import java.util.List;

import com.like.system.dept.domain.Dept;
import com.like.system.dept.domain.port.in.dto.DeptQueryDTO;

public interface DeptQueryDbPort {
	
	List<Dept> select(DeptQueryDTO dto);
}
