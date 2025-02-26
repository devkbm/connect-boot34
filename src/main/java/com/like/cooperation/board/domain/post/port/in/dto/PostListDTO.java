package com.like.cooperation.board.domain.post.port.in.dto;

public record PostListDTO(
	Long boardId,
	Long postId,
	String writerName,
	String writerImage,
	String title,
	int hitCount,
	Boolean editable,
	Boolean isAttachedFile,
    Integer fileCount,
    Boolean isRead) {	
}

