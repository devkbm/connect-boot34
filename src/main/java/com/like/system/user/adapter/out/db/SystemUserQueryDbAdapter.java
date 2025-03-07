package com.like.system.user.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.user.adapter.out.db.data.SystemUserRepository;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.port.in.dto.SystemUserQueryDTO;
import com.like.system.user.domain.port.out.SystemUserQueryDbPort;

@Repository
public class SystemUserQueryDbAdapter implements SystemUserQueryDbPort {

	SystemUserRepository repository;
	
	SystemUserQueryDbAdapter(SystemUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<SystemUser> selectList(SystemUserQueryDTO dto) {
		return this.repository.findAll(dto.getBooleanBuilder());
	}
	
	
}
