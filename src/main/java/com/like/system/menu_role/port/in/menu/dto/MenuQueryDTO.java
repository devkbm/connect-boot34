package com.like.system.menu_role.port.in.menu.dto;

import static org.springframework.util.StringUtils.hasText;

import com.like.system.menu_role.domain.menu.QMenu;
import com.like.system.menu_role.domain.menu.QMenuGroup;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import jakarta.validation.constraints.NotEmpty;

public record MenuQueryDTO(
		String companyCode,
		@NotEmpty(message = "필수 입력 값입니다.")
		String menuGroupCode,
		String menuCode,
		String menuName
		) {
	private static final QMenu qType = QMenu.menu;
	
	public BooleanBuilder getBooleanBuilder() {																
		return new BooleanBuilder()
				.and(equalOrganizationCode(this.companyCode))
				.and(equalMenuGroupCode(this.menuGroupCode))
	//			.and(likeMenuId(this.menuId))
				.and(likeMenuName(this.menuName));
	}

	private BooleanExpression equalOrganizationCode(String companyCode) {					
		return QMenuGroup.menuGroup.id.companyCode.eq(companyCode);
	}
	
	private BooleanExpression equalMenuGroupCode(String menuGroupCode) {					
		return QMenuGroup.menuGroup.id.menuGroupCode.eq(menuGroupCode);
	}
	/*
	private BooleanExpression likeMenuId(String menuId) {
		return hasText(menuId) ? qType.id.like("%"+menuId+"%") : null;					
	}
	*/
	private BooleanExpression likeMenuName(String menuName) {
		return hasText(menuName) ? qType.name.like("%"+menuName+"%") : null;					
	}
}
