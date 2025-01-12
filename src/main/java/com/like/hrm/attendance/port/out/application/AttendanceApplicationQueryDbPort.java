package com.like.hrm.attendance.port.out.application;

import java.util.List;

import com.like.hrm.attendance.port.in.application.dto.AttendanceApplicationQueryResultDTO;

public interface AttendanceApplicationQueryDbPort {

	List<AttendanceApplicationQueryResultDTO> select(String staffNo);
}
