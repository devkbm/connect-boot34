package com.like.system.hierarchycode.domain;

import java.util.List;

import com.like.system.hierarchycode.domain.port.in.dto.CodeComboDTO;
import com.querydsl.core.types.Predicate;

public interface CommonCodeQueryRepository {

	List<Code> getCodeList(String parentCodeId);
	
	List<Code> getCodeList(Predicate predicate);	
	
	List<CodeComboDTO> getCodeListByComboBox(String codeGroup);
}
