package com.like.cooperation.workcalendar.domain.port.in;

import com.like.cooperation.workcalendar.domain.port.in.dto.WorkCalendarEventSaveDTO;

public interface WorkCalendarEventSaveUseCase {

	void save(WorkCalendarEventSaveDTO dto);
}
