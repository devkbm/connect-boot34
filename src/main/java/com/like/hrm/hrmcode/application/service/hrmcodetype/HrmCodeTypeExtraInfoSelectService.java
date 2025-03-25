package com.like.hrm.hrmcode.application.service.hrmcodetype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.like.hrm.hrmcode.application.port.in.hrmcodetype.HrmCodeTypeExtraInfoSelectUseCase;
import com.like.hrm.hrmcode.application.port.out.hrmcodetype.HrmCodeTypeCommandDbPort;
import com.like.hrm.hrmcode.domain.HrmCodeType;

import jakarta.persistence.EntityNotFoundException;

@Service
public class HrmCodeTypeExtraInfoSelectService implements HrmCodeTypeExtraInfoSelectUseCase {

	HrmCodeTypeCommandDbPort dbPort;
	
	HrmCodeTypeExtraInfoSelectService(HrmCodeTypeCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<Map<String, String>> selectJson(String typeId) {

		HrmCodeType entity = dbPort.select(typeId).orElseThrow(() -> new EntityNotFoundException("Entity is not Found"));
		
		List<Map<String, String>> map = new ArrayList<>();
		
		String val = entity.getFieldConfig();
		
		try {
			map = stringToMap(val);
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		} 
		
		return map;
	}
	
	
	public List<Map<String, String>> stringToMap(String str) throws JsonMappingException, JsonProcessingException {
		if (!StringUtils.hasText(str)) return null;
					
		//return new ObjectMapper().readValue(str, new TypeReference<List<Map<String, String>>>() {});
		
		return new ObjectMapper().readValue(str, TypeFactory.defaultInstance().constructCollectionType(List.class,
		          TypeFactory.defaultInstance().constructMapType(Map.class, String.class, String.class)));
				
	}

}
