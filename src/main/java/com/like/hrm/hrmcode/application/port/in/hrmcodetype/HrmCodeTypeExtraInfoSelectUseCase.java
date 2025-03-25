package com.like.hrm.hrmcode.application.port.in.hrmcodetype;

import java.util.List;
import java.util.Map;

public interface HrmCodeTypeExtraInfoSelectUseCase {
	List<Map<String, String>> selectJson(String typeId);
}
