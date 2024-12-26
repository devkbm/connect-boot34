package com.like.cooperation.board.adapter.in.web.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.like.cooperation.board.port.in.post.PostQueryBySliceUseCase;
import com.like.cooperation.board.port.in.post.dto.PostListDTO;
import com.like.cooperation.board.port.in.post.dto.PostQueryDTO;
import com.like.core.util.SessionUtil;

@Controller
public class PostQueryBySliceController {

	PostQueryBySliceUseCase useCase;
	
	PostQueryBySliceController(PostQueryBySliceUseCase useCase) {
		this.useCase = useCase;
	}	
	
	@GetMapping("/api/grw/board/article_slice")
	public ResponseEntity<?> getArticleSlice(PostQueryDTO dto, Pageable pageable) {
																			  											
		Slice<PostListDTO> list = useCase.getAritlceSlice(SessionUtil.getUserId(), dto, pageable);
		
		return new ResponseEntity<Slice<PostListDTO>>(list, HttpStatus.OK);		
	}
}
