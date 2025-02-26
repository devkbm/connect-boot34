package com.like.system.menu_role.domain.role.port.in;

import java.util.List;

import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntity;
import com.like.system.menu_role.domain.role.port.in.dto.RoleQueryDTO;

public interface RoleQueryUseCase {
	List<RoleJpaEntity> getAuthorityList(RoleQueryDTO condition);
}
