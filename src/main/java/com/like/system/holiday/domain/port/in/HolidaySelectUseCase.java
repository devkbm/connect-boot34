package com.like.system.holiday.domain.port.in;

import java.time.LocalDate;

import com.like.system.holiday.domain.port.in.dto.HolidaySaveDTO;

public interface HolidaySelectUseCase {
	HolidaySaveDTO select(String companyCode, LocalDate date);
}
