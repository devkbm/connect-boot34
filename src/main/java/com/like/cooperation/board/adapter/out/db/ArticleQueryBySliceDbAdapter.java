package com.like.cooperation.board.adapter.out.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.mybatis.BoardMapper;
import com.like.cooperation.board.port.in.article.dto.ArticleListDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleQueryDTO;
import com.like.cooperation.board.port.out.ArticleQueryBySliceDbPort;

@Repository
public class ArticleQueryBySliceDbAdapter implements ArticleQueryBySliceDbPort {
	
	BoardMapper boardMapper;

	ArticleQueryBySliceDbAdapter(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
		
	@Override
	public Slice<ArticleListDTO> getAritlceSlice(String userId, ArticleQueryDTO dto, Pageable pageable) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("data", dto);
		//params.put("pageable", pageable );
		params.put("pagenumber",  pageable.getPageNumber() );
		params.put("pagesize", pageable.getPageSize() );
		
		List<ArticleListDTO> contents = boardMapper.getArticleList(params);
		
		// 마지막 데이터인지 여부를 확인하기 위해 +1개를 조회한후 데이터 제거
		boolean hasNext = false;
		if (contents.size() > pageable.getPageSize()) {
			contents.remove(pageable.getPageSize());
			hasNext = true;
		}
		
		return new SliceImpl<>(contents, pageable, hasNext);
	}
	
	
}
