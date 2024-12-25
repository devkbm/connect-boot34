package com.like.cooperation.board.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.data.ArticleAttachedFileRepository;
import com.like.cooperation.board.adapter.out.db.querydsl.ArticleSelectQuerydsl;
import com.like.cooperation.board.domain.QArticleAttachedFile;
import com.like.cooperation.board.port.in.article.dto.ArticleFormSelectDTO;
import com.like.cooperation.board.port.out.ArticleSelectDbPort;
import com.like.system.file.export.FileInfoDTO;
import com.like.system.file.export.FileInfoDTOSelectUseCase;

@Repository
public class ArticleSelectDbAdapter implements ArticleSelectDbPort {

	ArticleSelectQuerydsl query;
	ArticleAttachedFileRepository fileRepository;
	FileInfoDTOSelectUseCase fileSelectUseCase;
	
	private final QArticleAttachedFile qArticleAttachedFile = QArticleAttachedFile.articleAttachedFile;
	
	ArticleSelectDbAdapter(
			ArticleSelectQuerydsl query, 
			ArticleAttachedFileRepository fileRepository,
			FileInfoDTOSelectUseCase fileSelectUseCase) {
		this.query = query;
		this.fileRepository = fileRepository;
		this.fileSelectUseCase = fileSelectUseCase;
	}
	
	@Override
	public ArticleFormSelectDTO get(String readerUserId, Long articleId) {
		 ArticleFormSelectDTO dto = this.query.get(readerUserId, articleId);
		 
		 List<String> fileIds = this.fileRepository.findAll(qArticleAttachedFile.article.articleId.eq(articleId))
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
