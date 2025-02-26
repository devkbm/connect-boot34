package com.like.system.holiday.domain.port.out;

import java.time.LocalDate;

public interface HolidayDeletePort {
	void delete(String companyCode, LocalDate date);
}
