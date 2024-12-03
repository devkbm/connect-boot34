package com.like.cooperation.board.port.in.article.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.like.cooperation.board.domain.Article;
import com.like.cooperation.board.domain.ArticleContents;
import com.like.cooperation.board.domain.ArticlePassword;
import com.like.cooperation.board.domain.Board;

import jakarta.validation.constraints.NotEmpty;

public record ArticleSaveMultipartDTO(
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
	public Article newArticle(Board board) {									    			
		Article entity = Article.builder()	
					    .board(board)
					    .articleId(articleId)
					    .content(new ArticleContents(title, contents))						  						  
					    .password(new ArticlePassword(this.pwd))
					    .isFixedTop(isFiexedTop)
					    .build();
		
		entity.setAppUrl(clientAppUrl);
		
		return entity;
	}
    
    public void modifyArticle(Article entity) {
    	entity.modifyEntity(new ArticleContents(title, contents),isFiexedTop);
    	
    	entity.setAppUrl(clientAppUrl);
	}
    
    public boolean isNew() {
    	return this.articleId() == null ? true : false;
    }
}
