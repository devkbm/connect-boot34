package com.like.system.dept.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.dept.adapter.out.db.data.DeptJpaRepository;
import com.like.system.dept.application.dto.DeptQueryDTO;
import com.like.system.dept.application.port.out.DeptQueryDbPort;
import com.like.system.dept.domain.Dept;

@Repository
public class DeptQueryDbAdapter implements DeptQueryDbPort {

	DeptJpaRepository repository;
	
	public DeptQueryDbAdapter(DeptJpaRepository repository) {
		this.repository = repository;
	}	
	
	@Override
	public List<Dept> select(DeptQueryDTO dto) {
		return this.repository.findAll(dto.getCondition());
	}
	
}
