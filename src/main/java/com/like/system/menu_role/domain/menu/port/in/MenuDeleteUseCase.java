package com.like.system.menu_role.domain.menu.port.in;

public interface MenuDeleteUseCase {
	void delete(String companyCode, String menuGroupCode, String menuCode);
}
