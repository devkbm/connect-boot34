package com.like.system.company.domain.port.in;

import java.util.List;

import com.like.system.company.domain.port.in.dto.CompanyInfoSaveDTO;

public interface CompanyQueryUseCase {

	List<CompanyInfoSaveDTO> query();
}
