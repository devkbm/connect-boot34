package com.like.hrm.attendance.port.in.application;

import java.util.List;

import com.like.hrm.attendance.port.in.application.dto.AttendanceApplicationQueryResultDTO;

public interface AttendanceApplicationQueryUseCase {

	List<AttendanceApplicationQueryResultDTO> select(String staffNo);
}
