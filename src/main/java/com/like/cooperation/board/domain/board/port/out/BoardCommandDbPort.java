package com.like.cooperation.board.domain.board.port.out;

import java.util.Optional;

import com.like.cooperation.board.domain.board.Board;

public interface BoardCommandDbPort {
	Optional<Board> select(Long id);
	
	void save(Board entity);
	
	void delete(Long id);
}
