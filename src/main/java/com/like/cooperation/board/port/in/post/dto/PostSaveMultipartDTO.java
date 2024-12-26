package com.like.cooperation.board.port.in.post.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.like.cooperation.board.domain.Post;
import com.like.cooperation.board.domain.PostContents;
import com.like.cooperation.board.domain.PostPassword;
import com.like.cooperation.board.domain.Board;

import jakarta.validation.constraints.NotEmpty;

public record PostSaveMultipartDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,
		String companyCode,
		Long boardId,
		Long articleId,
		Long articleParentId,
		@NotEmpty(message="제목은 필수 입력 사항입니다.")
		String title,
		String contents,
		String pwd,
		int hitCount,						
		Integer depth,
		boolean isFiexedTop,
		@JsonIgnore
		List<MultipartFile> file
		) {
	public Post newArticle(Board board) {									    			
		Post entity = Post.builder()	
					    .board(board)
					    .articleId(articleId)
					    .content(new PostContents(title, contents))						  						  
					    .password(new PostPassword(this.pwd))
					    .isFixedTop(isFiexedTop)
					    .build();
		
		entity.setAppUrl(clientAppUrl);
		
		return entity;
	}
    
    public void modifyArticle(Post entity) {
    	entity.modifyEntity(new PostContents(title, contents),isFiexedTop);
    	
    	entity.setAppUrl(clientAppUrl);
	}
    
    public boolean isNew() {
    	return this.articleId() == null ? true : false;
    }
}
