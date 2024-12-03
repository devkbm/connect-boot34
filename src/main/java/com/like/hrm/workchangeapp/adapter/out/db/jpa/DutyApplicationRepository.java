package com.like.hrm.workchangeapp.adapter.out.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.workchangeapp.domain.WorkChangeApplication;

public interface DutyApplicationRepository extends JpaRepository<WorkChangeApplication, Long>, QuerydslPredicateExecutor<WorkChangeApplication> {	
	
}
