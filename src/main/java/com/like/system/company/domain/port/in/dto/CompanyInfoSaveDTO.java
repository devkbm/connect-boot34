package com.like.system.company.domain.port.in.dto;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record CompanyInfoSaveDTO(
		String clientAppUrl
		,String companyCode
		,String companyName
		,String businessRegistrationNumber
		,String coporationNumber
		,String nameOfRepresentative
		,LocalDate establishmentDate
		) {
}
