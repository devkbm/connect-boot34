package com.like.system.holiday.domain.port.in;

import java.time.LocalDate;

public interface HolidayDeleteUseCase {
	void delete(String companyCode, LocalDate date);
}
