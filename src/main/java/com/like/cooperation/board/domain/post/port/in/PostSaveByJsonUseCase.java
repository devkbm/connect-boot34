package com.like.cooperation.board.domain.post.port.in;

import com.like.cooperation.board.domain.post.port.in.dto.PostFormSaveDTO;

public interface PostSaveByJsonUseCase {
	void save(PostFormSaveDTO dto);	
}
