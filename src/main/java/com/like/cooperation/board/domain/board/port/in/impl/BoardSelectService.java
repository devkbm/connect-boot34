package com.like.cooperation.board.domain.board.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.domain.board.port.in.BoardSelectUseCase;
import com.like.cooperation.board.domain.board.port.in.dto.BoardSaveDTO;
import com.like.cooperation.board.domain.board.port.in.dto.BoardSaveDTOMapper;
import com.like.cooperation.board.domain.board.port.out.BoardCommandDbPort;

@Service
public class BoardSelectService implements BoardSelectUseCase {

	BoardCommandDbPort dbPort;
	
	BoardSelectService(BoardCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public BoardSaveDTO select(Long boardId) {
		return BoardSaveDTOMapper.toDTO(this.dbPort.select(boardId).orElse(null));
	}

}
