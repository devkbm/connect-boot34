package com.like.hrm.leaveapplication.adapter.out.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.leaveapplication.domain.WorkChangeCode;

public interface WorkChangeCodeRepository extends JpaRepository<WorkChangeCode, String>, QuerydslPredicateExecutor<WorkChangeCode> {

}
