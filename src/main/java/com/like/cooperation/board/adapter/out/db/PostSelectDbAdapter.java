package com.like.cooperation.board.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.data.PostAttachedFileRepository;
import com.like.cooperation.board.adapter.out.db.querydsl.PostSelectQuerydsl;
import com.like.cooperation.board.domain.QPostAttachedFile;
import com.like.cooperation.board.port.in.post.dto.PostFormSelectDTO;
import com.like.cooperation.board.port.out.PostSelectDbPort;
import com.like.system.file.export.FileInfoDTO;
import com.like.system.file.export.FileInfoDTOSelectUseCase;

@Repository
public class PostSelectDbAdapter implements PostSelectDbPort {

	PostSelectQuerydsl query;
	PostAttachedFileRepository fileRepository;
	FileInfoDTOSelectUseCase fileSelectUseCase;
	
	private final QPostAttachedFile qArticleAttachedFile = QPostAttachedFile.postAttachedFile;
	
	PostSelectDbAdapter(
			PostSelectQuerydsl query, 
			PostAttachedFileRepository fileRepository,
			FileInfoDTOSelectUseCase fileSelectUseCase) {
		this.query = query;
		this.fileRepository = fileRepository;
		this.fileSelectUseCase = fileSelectUseCase;
	}
	
	@Override
	public PostFormSelectDTO get(String readerUserId, Long articleId) {
		 PostFormSelectDTO dto = this.query.get(readerUserId, articleId);
		 
		 List<String> fileIds = this.fileRepository.findAll(qArticleAttachedFile.post.postId.eq(articleId))
												   .stream()
												   .map(e -> e.getFileInfo().toString())
												   .toList();
		 
		 
		 if (fileIds != null) {
			 List<FileInfoDTO> fileList = fileSelectUseCase.select(fileIds);
			 dto.addFileList(fileList);			 
		 }
		 
		return dto;
	}

}
