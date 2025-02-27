package com.like.cooperation.workcalendar.domain.port.in;

import java.util.List;

import com.like.cooperation.workcalendar.domain.port.in.dto.WorkCalendarEventQueryDTO;
import com.like.cooperation.workcalendar.domain.port.in.dto.WorkCalendarEventResponseDTO;

public interface WorkCalendarEventQueryUseCase {

	public List<WorkCalendarEventResponseDTO> getScheduleList(WorkCalendarEventQueryDTO searchCondition);
}
