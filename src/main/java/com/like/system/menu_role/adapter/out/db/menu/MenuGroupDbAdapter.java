package com.like.system.menu_role.adapter.out.db.menu;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.adapter.out.db.menu.data.MenuGroupJpaRepository;
import com.like.system.menu_role.application.dto.menu.MenuGroupQueryDTO;
import com.like.system.menu_role.application.port.out.menu.MenuGroupDeleteDbPort;
import com.like.system.menu_role.application.port.out.menu.MenuGroupSaveDbPort;
import com.like.system.menu_role.application.port.out.menu.MenuGroupSelectDbPort;
import com.like.system.menu_role.domain.menu.MenuGroup;
import com.like.system.menu_role.domain.menu.MenuGroupId;

@Repository
public class MenuGroupDbAdapter implements MenuGroupSelectDbPort, MenuGroupSaveDbPort, MenuGroupDeleteDbPort {

	MenuGroupJpaRepository repository;
	
	MenuGroupDbAdapter(MenuGroupJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public MenuGroup select(String companyCode, String menuGroupCode) {		
		
		return this.repository.findById(new MenuGroupId(companyCode, menuGroupCode)).orElse(null); 
	}

	@Override
	public List<MenuGroup> selectList(MenuGroupQueryDTO dto) {		
		return this.repository.findAll(dto.getBooleanBuilder());
	}
	
	@Override
	public void save(MenuGroup entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(String companyCode, String menuGroupCode) {
		this.repository.deleteById(new MenuGroupId(companyCode, menuGroupCode));		
	}
	
}
