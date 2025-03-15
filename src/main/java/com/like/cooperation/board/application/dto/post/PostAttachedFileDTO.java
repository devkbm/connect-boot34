package com.like.cooperation.board.application.dto.post;

import lombok.Builder;

@Builder
public record PostAttachedFileDTO(
		String uid,
		String name,
		Long size,
		String contentType,
		String url
		) {

}
