package com.like.cooperation.workcalendar.domain.port.in;

import com.like.cooperation.workcalendar.domain.port.in.dto.WorkCalendarSaveDTO;

public interface WorkCalendarSaveUseCase {
	void save(WorkCalendarSaveDTO dto);
}
