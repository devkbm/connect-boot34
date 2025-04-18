package com.like.hrm.payitem.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.domain.model.PayItem;

@Repository
public interface PayJpaRepository extends JpaRepository<PayItem, String>, QuerydslPredicateExecutor<PayItem> {

}
