package com.like.hrm.workchangeapp.adapter.out.db.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.workchangeapp.domain.QWorkChangeCode;
import com.like.hrm.workchangeapp.domain.WorkChangeCode;
import com.like.hrm.workchangeapp.port.in.WorkChangeCodeDTO.SearchDutyCode;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class DutyCodeQueryJpaRepository implements WorkChangeCodeQueryRepository {

	private JPAQueryFactory	queryFactory;
	
	public DutyCodeQueryJpaRepository(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}

	@Override
	public List<WorkChangeCode> getDutyCodeList(SearchDutyCode condition) {
		return queryFactory
				.selectFrom(QWorkChangeCode.workChangeCode)
				.where(condition.getBooleanBuilder())
				.fetch();
	}
}
