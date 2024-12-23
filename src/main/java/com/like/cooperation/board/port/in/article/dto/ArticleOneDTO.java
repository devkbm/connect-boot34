package com.like.cooperation.board.port.in.article.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.like.system.file.export.FileResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleOneDTO {

	LocalDateTime createdDt;
	String createdBy;
	LocalDateTime modifiedDt;
	String modifiedBy;
	String userName;
	String boardId;
	String articleId;
	Long articleParentId;
	String title;
	String contents;
	String pwd;
	int hitCount;				
	Integer depth;	
	Boolean editable;	
	List<FileResponseDTO> fileList;
		
}
