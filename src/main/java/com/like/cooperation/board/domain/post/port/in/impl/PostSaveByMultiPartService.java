package com.like.cooperation.board.domain.post.port.in.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.board.domain.board.Board;
import com.like.cooperation.board.domain.board.port.out.BoardCommandDbPort;
import com.like.cooperation.board.domain.post.Post;
import com.like.cooperation.board.domain.post.PostAttachedFile;
import com.like.cooperation.board.domain.post.port.in.PostSaveByMultiPartUseCase;
import com.like.cooperation.board.domain.post.port.in.dto.PostSaveMultipartDTO;
import com.like.cooperation.board.domain.post.port.out.PostCommandDbPort;
import com.like.core.util.SessionUtil;
import com.like.system.file.domain.FileInfo;
import com.like.system.file.domain.port.in.FileServerSelectUseCase;
import com.like.system.file.domain.port.in.FileServerUploadUseCase;

@Transactional
@Service
public class PostSaveByMultiPartService implements PostSaveByMultiPartUseCase {

	PostCommandDbPort dbPort;
	BoardCommandDbPort boardDbPort;
	FileServerUploadUseCase uploadUseCase;
	FileServerSelectUseCase fileSelectUseCase;
	
	PostSaveByMultiPartService(PostCommandDbPort dbPort,
					   BoardCommandDbPort boardDbPort,
					   FileServerUploadUseCase uploadUseCase,
				       FileServerSelectUseCase fileSelectUseCase) {
		this.dbPort = dbPort;
		this.boardDbPort = boardDbPort;
		this.uploadUseCase = uploadUseCase;
		this.fileSelectUseCase = fileSelectUseCase;
	}	

	@Override
	public void save(PostSaveMultipartDTO dto) {
		Board board = boardDbPort.select(dto.boardId())
								 .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시판입니다."));
		
		List<FileInfo> fileInfoList = null;
		List<PostAttachedFile> attachedFileList = null;							
		
		Post article = dto.newArticle(board);
		
		// 첨부파일 저장
		if (!dto.file().isEmpty()) {		
			String userId = SessionUtil.getUserId();
			
			fileInfoList = uploadUseCase.uploadFile(dto.file(), userId, "board");
			
			//attachedFileList = AttachedFileConverter.convert(article, fileInfoList);
		}
		
		article.setFiles(attachedFileList);
		
		this.dbPort.save(article);		
	}		

}
