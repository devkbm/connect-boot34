package com.like.system.hierarchycode.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.hierarchycode.domain.Code;
import com.like.system.hierarchycode.domain.CommonCodeQueryRepository;
import com.like.system.hierarchycode.port.in.dto.CodeComboDTO;
import com.like.system.hierarchycode.port.in.dto.HierarchyCodeQueryDTO;

@Service
@Transactional(readOnly=true)
public class HierarchyCodeQueryService {

	private CommonCodeQueryRepository codeRepository;
			
	public HierarchyCodeQueryService(CommonCodeQueryRepository codeRepository) {
		this.codeRepository = codeRepository;
	}
		
	public List<Code> getCodeList(String parentCodeId) {		
		return codeRepository.getCodeList(parentCodeId);
	}
	
	public List<Code> getCodeList(HierarchyCodeQueryDTO searchCondition) {		
		return codeRepository.getCodeList(searchCondition.getCondition());
	}	
	
	public List<CodeComboDTO> getCodeListByComboBox(String codeGroup) {
		return codeRepository.getCodeListByComboBox(codeGroup);
	}	
}
