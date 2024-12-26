package com.like.cooperation.board.port.out;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.like.cooperation.board.port.in.post.dto.PostListDTO;
import com.like.cooperation.board.port.in.post.dto.PostQueryDTO;

public interface PostQueryBySliceDbPort {
	
	Slice<PostListDTO> getAritlceSlice(String userId, PostQueryDTO dto, Pageable pageable);
}
