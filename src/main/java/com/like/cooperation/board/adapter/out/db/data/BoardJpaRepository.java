package com.like.cooperation.board.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.like.cooperation.board.domain.Board;

public interface BoardJpaRepository extends JpaRepository<Board, Long> {	
			
}