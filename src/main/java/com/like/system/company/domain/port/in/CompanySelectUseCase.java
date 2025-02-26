package com.like.system.company.domain.port.in;

import com.like.system.company.domain.port.in.dto.CompanyInfoSaveDTO;

import jakarta.annotation.Nullable;

public interface CompanySelectUseCase {
	@Nullable CompanyInfoSaveDTO select(String companyCode);
}
