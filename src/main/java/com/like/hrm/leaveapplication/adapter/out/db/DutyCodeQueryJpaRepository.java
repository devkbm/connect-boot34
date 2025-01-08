package com.like.hrm.leaveapplication.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.leaveapplication.domain.WorkChangeCode;
import com.like.hrm.leaveapplication.port.in.WorkChangeCodeDTO.SearchDutyCode;
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
