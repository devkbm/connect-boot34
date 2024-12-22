package com.like.system.menu_role.port.in.menu_role.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.menu_role.port.in.menu_role.MenuRoleMappingSaveUseCase;
import com.like.system.menu_role.port.in.menu_role.dto.MenuRoleMappingSaveDTO;
import com.like.system.menu_role.port.in.menu_role.dto.MenuRoleMappingSaveDTOMapper;
import com.like.system.menu_role.port.out.menu_role.MenuRoleMappingSaveDbPort;

@Transactional
@Service
public class MenuRoleMappingSaveService implements MenuRoleMappingSaveUseCase {

	MenuRoleMappingSaveDbPort dbPort;
	
	MenuRoleMappingSaveService(MenuRoleMappingSaveDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(List<MenuRoleMappingSaveDTO> dtoList) {
		this.dbPort.clear(dtoList.get(0).companyCode(), dtoList.get(0).menuGroupCode(), dtoList.get(0).roleCode());
		
		this.dbPort.save(dtoList.stream().map(e -> MenuRoleMappingSaveDTOMapper.toEntity(e)).toList());		
	}

}