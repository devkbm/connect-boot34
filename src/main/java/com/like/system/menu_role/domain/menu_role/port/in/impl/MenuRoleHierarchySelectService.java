package com.like.system.menu_role.domain.menu_role.port.in.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.domain.menu_role.MenuRoleHierarchy;
import com.like.system.menu_role.domain.menu_role.MenuRoleHierarchyGenerator;
import com.like.system.menu_role.domain.menu_role.port.in.MenuRoleHierarchySelectUseCase;
import com.like.system.menu_role.domain.menu_role.port.in.dto.MenuRoleHierarchyDTOByNgZorro;
import com.like.system.menu_role.domain.menu_role.port.out.MenuRoleHierarchySelectDbPort;

@Service
public class MenuRoleHierarchySelectService implements MenuRoleHierarchySelectUseCase {

	MenuRoleHierarchySelectDbPort dbPort;
	
	MenuRoleHierarchySelectService(MenuRoleHierarchySelectDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<?> select(String companyCode, String menuGroupCode, String roleCode) {
		MenuRoleHierarchyGenerator generator = new MenuRoleHierarchyGenerator(this.dbPort.select(companyCode, menuGroupCode, roleCode));
		
		List<MenuRoleHierarchy> list = generator.convertTreeNodes();

		List<MenuRoleHierarchyDTOByNgZorro> copy_list = new ArrayList<>();
		
		copyTreeNode(list, copy_list);
		
		for ( MenuRoleHierarchyDTOByNgZorro dto : copy_list ) {
			MenuRoleHierarchyNgZorroHalfChecker.setHalfChecked(dto);
		}
		
		return copy_list;
	}

	private void copyTreeNode(List<MenuRoleHierarchy> original_list, List<MenuRoleHierarchyDTOByNgZorro> copy_list) {
		MenuRoleHierarchyDTOByNgZorro newNode = null;
		
		for (MenuRoleHierarchy node: original_list) {
			newNode = convert(node);
			copyChildren(newNode, node);
			copy_list.add(newNode);
		}
	}
	
	private void copyChildren(MenuRoleHierarchyDTOByNgZorro parent, MenuRoleHierarchy original) {
		MenuRoleHierarchyDTOByNgZorro newNode = null;
		
		if (original.getChildren() == null) return;
		
		for (MenuRoleHierarchy node: original.getChildren()) {
			newNode = convert(node);
			if (parent.getChildren() == null) parent.setChildren(new ArrayList<>());
			
			parent.getChildren().add(newNode);
			copyChildren(newNode, node);
		}
	}
	
	private MenuRoleHierarchyDTOByNgZorro convert(MenuRoleHierarchy dto) {
		return MenuRoleHierarchyDTOByNgZorro.build(dto);
	}

}
