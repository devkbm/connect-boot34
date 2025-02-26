package com.like.cooperation.workcalendar.domain.port.in;

import com.like.cooperation.workcalendar.domain.port.in.dto.WorkCalendarEventResponseDTO;

public interface WorkCalendarEventSelectUseCase {
	WorkCalendarEventResponseDTO select(Long id);
}
