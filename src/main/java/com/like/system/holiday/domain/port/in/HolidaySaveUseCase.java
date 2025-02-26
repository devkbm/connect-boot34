package com.like.system.holiday.domain.port.in;

import com.like.system.holiday.domain.port.in.dto.HolidaySaveDTO;

public interface HolidaySaveUseCase {
	void save(HolidaySaveDTO dto);
}
