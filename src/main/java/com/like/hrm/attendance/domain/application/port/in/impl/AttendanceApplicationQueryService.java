package com.like.hrm.attendance.domain.application.port.in.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.attendance.domain.application.port.in.AttendanceApplicationQueryUseCase;
import com.like.hrm.attendance.domain.application.port.in.dto.AttendanceApplicationQueryResultDTO;
import com.like.hrm.attendance.domain.application.port.out.AttendanceApplicationQueryDbPort;

@Transactional(readOnly = true)
@Service
public class AttendanceApplicationQueryService implements AttendanceApplicationQueryUseCase {

	AttendanceApplicationQueryDbPort dbPort;
	
	AttendanceApplicationQueryService(AttendanceApplicationQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<AttendanceApplicationQueryResultDTO> select(String staffNo) {
		return dbPort.select(staffNo);
	}

}
