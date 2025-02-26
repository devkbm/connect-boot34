package com.like.cooperation.board.domain.board.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.domain.board.port.in.BoardDeleteUseCase;
import com.like.cooperation.board.domain.board.port.out.BoardCommandDbPort;

@Service
public class BoardDeleteService implements BoardDeleteUseCase {

	BoardCommandDbPort dbPort;
	
	BoardDeleteService(BoardCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);
	}

}
