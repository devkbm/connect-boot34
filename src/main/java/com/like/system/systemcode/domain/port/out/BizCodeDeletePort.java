package com.like.system.systemcode.domain.port.out;

public interface BizCodeDeletePort {
	void delete(String companyCode, String typeId, String code);
}
