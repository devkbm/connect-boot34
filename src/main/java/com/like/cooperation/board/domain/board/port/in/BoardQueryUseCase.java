package com.like.cooperation.board.domain.board.port.in;

import java.util.List;

import com.like.cooperation.board.domain.board.port.in.dto.BoardHierarchy;
import com.like.cooperation.board.domain.board.port.in.dto.BoardQueryDTO;
import com.like.cooperation.board.domain.board.port.in.dto.BoardSaveDTO;

public interface BoardQueryUseCase {	
	
	List<BoardSaveDTO> selectList(BoardQueryDTO dto);
	
	List<BoardHierarchy> selectHierarchy();
}
