package com.like.cooperation.board.adapter.out.db.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.like.cooperation.board.domain.post.port.in.dto.PostListDTO;

@Mapper
public interface BoardMapper {
					
	/**
	 * 게시글 리스트 조회
	 * @param map
	 * @return
	 * @throws Exception
	 */		
	List<PostListDTO> getArticleList(Map<String, Object> params);
			
}
