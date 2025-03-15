package com.like.cooperation.board.application.port.in.post;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface PostAttachedFileUploadUseCase {

	void upload(Long postId, List<MultipartFile> mFileList);
}
