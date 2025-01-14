package com.like.hrm.attendance.adapter.out.db.code;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.attendance.domain.application.WorkChangeCode;
import com.like.hrm.attendance.port.in.code.dto.WorkChangeCodeDTO.SearchDutyCode;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class DutyCodeQueryJpaRepository implements WorkChangeCodeQueryRepository {

	private JPAQueryFactory	queryFactory;
	
	public DutyCodeQueryJpaRepository(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}

	@Override
	public List<WorkChangeCode> getDutyCodeList(SearchDutyCode condition) {
		return null;
		/*
		return queryFactory
				.selectFrom(QWorkChangeCode.workChangeCode)
				.where(condition.getBooleanBuilder())
				.fetch();*/
	}
}