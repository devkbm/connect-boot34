package com.like.system.user.domain.port.in.dto;

import java.util.List;

import com.like.excel.upload.ExcelHeader;

public class SystemUserSaveByExcelDTO2 {

	String clientAppUrl;
	@ExcelHeader("사용자아이디") String userId;	
	@ExcelHeader("회사코드") String companyCode;	
	@ExcelHeader("직원번호") String staffNo;
	@ExcelHeader("직원명") String name;
	@ExcelHeader("부서코드") String deptCode;		
	@ExcelHeader("핸드폰번호") String mobileNum;
	@ExcelHeader("이메일") String email;			
	@ExcelHeader("사용여부")Boolean enabled;
	@ExcelHeader("롤리스트")List<String> roleList;
	@ExcelHeader("메뉴그룹리스트")List<String> menuGroupList;
}
