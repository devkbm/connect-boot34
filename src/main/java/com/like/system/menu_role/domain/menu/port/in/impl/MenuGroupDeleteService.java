package com.like.system.menu_role.domain.menu.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.domain.menu.port.in.MenuGroupDeleteUseCase;
import com.like.system.menu_role.domain.menu.port.out.MenuGroupDeleteDbPort;

@Service
public class MenuGroupDeleteService implements MenuGroupDeleteUseCase {

	MenuGroupDeleteDbPort port;
	
	MenuGroupDeleteService(MenuGroupDeleteDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String menuGroupCode) {
		this.port.delete(companyCode, menuGroupCode);
	}

}
