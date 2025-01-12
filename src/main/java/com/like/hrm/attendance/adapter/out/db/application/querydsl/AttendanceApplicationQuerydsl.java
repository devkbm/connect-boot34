package com.like.hrm.attendance.adapter.out.db.application.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.attendance.domain.application.QAttendanceApplication;
import com.like.hrm.attendance.port.in.application.dto.AttendanceApplicationQueryResultDTO;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class AttendanceApplicationQuerydsl {

	private final QAttendanceApplication qApplication = QAttendanceApplication.attendanceApplication;
	
	private JPAQueryFactory queryFactory;
	
	AttendanceApplicationQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<AttendanceApplicationQueryResultDTO> select(String staffNo) {
		return queryFactory
				.select(
					Projections.fields(AttendanceApplicationQueryResultDTO.class,
							qApplication.id,
							qApplication.staffNo,
							qApplication.staffNo.as("staffName"),
							qApplication.dutyCode,
							qApplication.dutyCode.as("dutyName"),
							qApplication.dutyReason,
							qApplication.period.from.as("fromDate"),
							qApplication.period.to.as("toDate")
					)
				)
				.from(qApplication)
				.where(qApplication.staffNo.eq(staffNo))
				.fetch();
				
	}
}
