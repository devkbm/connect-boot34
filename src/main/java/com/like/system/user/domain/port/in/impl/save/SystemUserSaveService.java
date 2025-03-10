package com.like.system.user.domain.port.in.impl.save;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.like.system.dept.domain.Dept;
import com.like.system.dept.domain.port.out.DeptCommandDbPort;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserCompany;
import com.like.system.user.domain.SystemUserCompanyRole;
import com.like.system.user.domain.SystemUserPassword;
import com.like.system.user.domain.port.in.SystemUserSaveUseCase;
import com.like.system.user.domain.port.in.dto.SystemUserSaveByExcelDTO;
import com.like.system.user.domain.port.in.dto.SystemUserSaveDTO;
import com.like.system.user.domain.port.out.SystemUserCommandDbPort;
import com.like.system.user.domain.port.out.SystemUserCompanyCommandDbPort;
import com.like.system.user.domain.port.out.SystemUserRoleCommandDbPort;

@Transactional
@Service
public class SystemUserSaveService implements SystemUserSaveUseCase {

	SystemUserCommandDbPort dbPort;		
	SystemUserRoleCommandDbPort userRoleDbPort;
	SystemUserCompanyCommandDbPort userCompanyDbPort;
	DeptCommandDbPort deptDbPort;
	PasswordEncoder passwordEncoder;
	
	SystemUserSaveService(SystemUserCommandDbPort dbPort						  
						 ,SystemUserRoleCommandDbPort userRoleDbPort
						 ,SystemUserCompanyCommandDbPort userCompanyDbPort 
						 ,DeptCommandDbPort deptDbPort
						 ,PasswordEncoder passwordEncoder) {
		this.dbPort = dbPort;		
		this.userRoleDbPort = userRoleDbPort;
		this.userCompanyDbPort = userCompanyDbPort;
		this.deptDbPort = deptDbPort;
		this.passwordEncoder = passwordEncoder;		
	}
	
	@Override
	public void save(SystemUserSaveDTO dto) {
		Dept dept = StringUtils.hasText(dto.deptCode()) ? deptDbPort.select(dto.companyCode(), dto.deptCode()).orElse(null) : null;
		SystemUser user = this.dbPort.select(dto.userId());
		
		if (user == null) {
			user = dto.newUser(dept);
			user.setPassword(passwordEncoder, SystemUserPassword.getInitPassword());
		} else {
			dto.modifyUser(user, dept);
		}							
				
		this.dbPort.save(user);
		
		SystemUserCompany userCompany = new SystemUserCompany(user, dto.companyCode(), dto.deptCode(), true); 
		this.userCompanyDbPort.save(userCompany);
		
		this.userRoleDbPort.delete(user.getRoleList(dto.companyCode()).stream().toList());					
		this.userRoleDbPort.save(this.toSystemUserRole(dto, user));							
	}	

	@Override
	public void save(List<SystemUserSaveByExcelDTO> dtos) {
		for(SystemUserSaveByExcelDTO dto : dtos ) {
		
			Dept dept = StringUtils.hasText(dto.deptCode()) ? deptDbPort.select(dto.companyCode(), dto.deptCode()).orElse(null) : null;
			SystemUser user = this.dbPort.select(dto.userId());
			
			if (user == null) {
				user = dto.newUser(dept);
				user.setPassword(passwordEncoder, SystemUserPassword.getInitPassword());
			} else {
				//dto.modifyUser(user, dept);
			}							
					
			this.dbPort.save(user);
			
			SystemUserCompany userCompany = new SystemUserCompany(user, dto.companyCode(), dto.deptCode(), true); 
			this.userCompanyDbPort.save(userCompany);
			
			this.userRoleDbPort.delete(user.getRoleList(dto.companyCode()).stream().toList());					
			this.userRoleDbPort.save(this.toSystemUserRole(dto, user));		
		}
				
	}
	
	private List<SystemUserCompanyRole> toSystemUserRole(SystemUserSaveDTO dto, SystemUser user) {
		// String userId, String companyCode, String roleCode
		return this.userRoleDbPort.select(dto.companyCode(), dto.roleList())
								  .stream()
								  .map(e -> new SystemUserCompanyRole(user, dto.companyCode(), e.getRoleCode()))
								  .toList();
	}
	
	private List<SystemUserCompanyRole> toSystemUserRole(SystemUserSaveByExcelDTO dto, SystemUser user) {
		// String userId, String companyCode, String roleCode
		return this.userRoleDbPort.select(dto.companyCode(), dto.roleList())
								  .stream()
								  .map(e -> new SystemUserCompanyRole(user, dto.companyCode(), e.getRoleCode()))
								  .toList();
	}

}
