package com.like.cooperation.board.port.in.post.dto;

public record PostListDTO(
	Long boardId,
	Long articleId,
	String writerName,
	String writerImage,
	String title,
	int hitCount,
	Boolean editable,
	Boolean isAttachedFile,
    Integer fileCount,
    Boolean isRead) {	
}

