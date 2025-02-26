package com.like.cooperation.workcalendar.domain.port.in;

import com.like.cooperation.workcalendar.domain.port.in.dto.WorkCalendarSaveDTO;

public interface WorkCalendarSelectUseCase {

	WorkCalendarSaveDTO select(Long id);
}
