package com.like.hrm.payitem.application.port.in;

import com.like.hrm.payitem.application.dto.PayItemFormDTO;

public interface PayItemSelectUseCase {
	PayItemFormDTO select(String companyCode, String itemCode);
}
