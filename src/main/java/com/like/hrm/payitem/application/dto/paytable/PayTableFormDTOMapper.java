package com.like.hrm.payitem.application.dto.paytable;

import com.like.hrm.payitem.domain.PayTable;

public class PayTableFormDTOMapper {

	public static PayTableFormDTO toDTO(PayTable entity) {
		if (entity == null) return null;
				
		return PayTableFormDTO
				.builder()
				.build();
	}
}
