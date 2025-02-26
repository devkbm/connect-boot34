package com.like.hrm.attendance.adapter.out.db.application;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.attendance.adapter.out.db.application.querydsl.AttendanceApplicationQuerydsl;
import com.like.hrm.attendance.domain.application.port.in.dto.AttendanceApplicationQueryResultDTO;
import com.like.hrm.attendance.domain.application.port.out.AttendanceApplicationQueryDbPort;

@Repository
public class AttendanceApplicationQueryDbAdapter implements AttendanceApplicationQueryDbPort {

	AttendanceApplicationQuerydsl querydsl;
	
	AttendanceApplicationQueryDbAdapter(AttendanceApplicationQuerydsl querydsl) {
		this.querydsl = querydsl;
	}
	
	@Override
	public List<AttendanceApplicationQueryResultDTO> select(String staffNo) {
		return querydsl.select(staffNo);
	}

}
