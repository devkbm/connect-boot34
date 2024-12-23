package com.like.cooperation.board.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.like.cooperation.board.domain.ArticleAttachedFile;

public interface ArticleAttachedFileRepository extends JpaRepository<ArticleAttachedFile, Long>, ListQuerydslPredicateExecutor<ArticleAttachedFile> {

}
