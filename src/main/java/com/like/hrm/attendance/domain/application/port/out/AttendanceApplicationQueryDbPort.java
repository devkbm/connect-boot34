package com.like.hrm.attendance.domain.application.port.out;

import java.util.List;

import com.like.hrm.attendance.domain.application.port.in.dto.AttendanceApplicationQueryResultDTO;

public interface AttendanceApplicationQueryDbPort {

	List<AttendanceApplicationQueryResultDTO> select(String staffNo);
}
