package com.like.system.company.domain.port.out;

import java.util.Optional;

import com.like.system.company.domain.CompanyInfo;
import com.like.system.company.domain.CompanyInfoId;

public interface CompanyCommandDbPort {

	Optional<CompanyInfo> select(CompanyInfoId companyId);
	
	void save(CompanyInfo entity);

	void delete(CompanyInfoId companyId);
}
