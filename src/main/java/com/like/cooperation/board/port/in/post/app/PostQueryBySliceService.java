package com.like.cooperation.board.port.in.post.app;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.board.port.in.post.PostQueryBySliceUseCase;
import com.like.cooperation.board.port.in.post.dto.PostListDTO;
import com.like.cooperation.board.port.in.post.dto.PostQueryDTO;
import com.like.cooperation.board.port.out.PostQueryBySliceDbPort;

@Transactional(readOnly = true)
@Service
public class PostQueryBySliceService implements PostQueryBySliceUseCase {

	PostQueryBySliceDbPort dbPort;
	
	PostQueryBySliceService(PostQueryBySliceDbPort dbPort) {
		this.dbPort = dbPort;
	}
		
	@Override
	public Slice<PostListDTO> getAritlceSlice(String userId, PostQueryDTO dto, Pageable pageable) {
		return this.dbPort.getAritlceSlice(userId, dto, pageable);
	}

	
}
