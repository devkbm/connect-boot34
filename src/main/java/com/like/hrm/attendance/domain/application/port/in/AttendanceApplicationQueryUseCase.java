package com.like.hrm.attendance.domain.application.port.in;

import java.util.List;

import com.like.hrm.attendance.domain.application.port.in.dto.AttendanceApplicationQueryResultDTO;

public interface AttendanceApplicationQueryUseCase {

	List<AttendanceApplicationQueryResultDTO> select(String staffNo);
}
