package com.like.cooperation.board.port.in.article.app;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.like.cooperation.board.domain.Article;
import com.like.cooperation.board.domain.ArticleAttachedFile;
import com.like.cooperation.board.domain.AttachedFileConverter;
import com.like.cooperation.board.domain.Board;
import com.like.cooperation.board.port.in.article.ArticleSaveByJsonUseCase;
import com.like.cooperation.board.port.in.article.dto.ArticleSaveDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleSaveDTOMapper;
import com.like.cooperation.board.port.out.ArticleCommandDbPort;
import com.like.cooperation.board.port.out.BoardCommandDbPort;
import com.like.cooperation.board.util.Base64Util;
import com.like.system.file.export.FileInfoDTO;
import com.like.system.file.export.FileInfoDTOSelectUseCase;
import com.like.system.file.export.FileUploadUseCase;

@Transactional
@Service
public class ArticleSaveByJsonService implements ArticleSaveByJsonUseCase {

	ArticleCommandDbPort dbPort;
	BoardCommandDbPort boardDbPort;
	FileUploadUseCase uploadUseCase;	
	FileInfoDTOSelectUseCase fileSelectUseCase;
	
	ArticleSaveByJsonService(ArticleCommandDbPort dbPort,
					   BoardCommandDbPort boardDbPort,
					   FileUploadUseCase uploadUseCase,
					   FileInfoDTOSelectUseCase fileSelectUseCase) {
		this.dbPort = dbPort;
		this.boardDbPort = boardDbPort;
		this.uploadUseCase = uploadUseCase;		
		this.fileSelectUseCase = fileSelectUseCase;
	}
	
	@Override
	public void save(ArticleSaveDTO dto) {
		Board board = boardDbPort.select(Base64Util.fromBase64Decode(dto.boardId()))
								 .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시판입니다."));		
						
		Article entity = StringUtils.hasText(dto.articleId()) == true ? this.findArticle(dto.articleId()) : null; 
								
		if (entity == null) {
			entity = ArticleSaveDTOMapper.newArticle(dto, board); 
		} else {
			ArticleSaveDTOMapper.modifyArticle(dto, entity);
		}
		
		if (dto.attachFile() != null) {
			List<FileInfoDTO> fileInfoList = Collections.emptyList();
			List<ArticleAttachedFile> attachedFileList = Collections.emptyList();
			
			// 저장된 파일 리스트를 조회한다.
			fileInfoList = fileSelectUseCase.select(dto.attachFile());
		
			// FileInfo를 AttachedFile로 변환한다.
			attachedFileList = AttachedFileConverter.convert(entity, fileInfoList);				
			if (!attachedFileList.isEmpty()) entity.setFiles(attachedFileList);
		}
		
		this.dbPort.save(entity);		
	}
	
	private Article findArticle(String articleId) {
		return this.dbPort.select(Base64Util.fromBase64Decode(articleId)).orElse(null);
	}

}
