package com.like.cooperation.board.application.service.post;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.application.port.in.post.PostAttachedFileDeleteUseCase;
import com.like.cooperation.board.application.port.out.post.PostAttachedFileDbPort;
import com.like.cooperation.board.application.port.out.post.PostCommandDbPort;
import com.like.cooperation.board.domain.post.Post;
import com.like.cooperation.board.domain.post.PostAttachedFile;
import com.like.cooperation.board.util.Base64Util;
import com.like.system.file.export.FileDeleteUseCase;

@Service
public class PostAttachedFileDeleteService implements PostAttachedFileDeleteUseCase {

	PostCommandDbPort dbPort;
	PostAttachedFileDbPort attachedFileDbPort;
	
	FileDeleteUseCase fileDeleteUseCase;
	
	PostAttachedFileDeleteService(
			PostCommandDbPort dbPort,
			PostAttachedFileDbPort attachedFileDbPort,
			FileDeleteUseCase fileDeleteUseCase) {
		this.dbPort = dbPort;
		this.attachedFileDbPort = attachedFileDbPort;
		
		this.fileDeleteUseCase = fileDeleteUseCase;
	}
	
	@Override
	public void delete(String postId, String fileId) {
		
		Post entity = this.dbPort.select(Base64Util.fromBase64Decode(postId))
								 .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시글입니다." + postId));
		
		
		Optional<PostAttachedFile> attachedFile = entity.getAttachedFileInfoList()
														.stream()
														.filter(e -> e.getFileInfo().toString().equals(fileId))
														.findFirst();
		
		this.attachedFileDbPort.delete(attachedFile.get().getPkArticleFile());
		
		entity.getAttachedFileInfoList().remove(attachedFile.get());			
		
		this.fileDeleteUseCase.delete(fileId);		
	}

}
