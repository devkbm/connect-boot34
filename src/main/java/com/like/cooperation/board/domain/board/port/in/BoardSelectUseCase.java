package com.like.cooperation.board.domain.board.port.in;

import com.like.cooperation.board.domain.board.port.in.dto.BoardSaveDTO;

public interface BoardSelectUseCase {
	BoardSaveDTO select(Long boardId);
}
