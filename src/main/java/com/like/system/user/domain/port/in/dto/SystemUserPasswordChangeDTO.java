package com.like.system.user.domain.port.in.dto;

public record SystemUserPasswordChangeDTO(
		String companyCode,
		String userId,
		String beforePassword,
		String afterPassword
		) {	
}