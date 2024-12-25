package com.like.cooperation.board.port.in.article.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.like.cooperation.board.domain.Article;
import com.like.cooperation.board.domain.ArticleAttachedFile;
import com.like.cooperation.board.domain.AttachedFileConverter;
import com.like.cooperation.board.domain.Board;
import com.like.cooperation.board.port.in.article.ArticleSaveByJsonUseCase;
import com.like.cooperation.board.port.in.article.dto.ArticleFormSaveDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleFormSaveDTOMapper;
import com.like.cooperation.board.port.out.ArticleAttachedFileDbPort;
import com.like.cooperation.board.port.out.ArticleCommandDbPort;
import com.like.cooperation.board.port.out.BoardCommandDbPort;
import com.like.cooperation.board.util.Base64Util;
import com.like.system.file.export.FileInfoDTO;
import com.like.system.file.export.FileInfoDTOSelectUseCase;
import com.like.system.file.export.FileUploadUseCase;

@Transactional
@Service
public class ArticleSaveByJsonService implements ArticleSaveByJsonUseCase {

	BoardCommandDbPort boardDbPort;
	ArticleCommandDbPort dbPort;
	ArticleAttachedFileDbPort attachedFileDbPort;
	
	FileUploadUseCase uploadUseCase;	
	FileInfoDTOSelectUseCase fileSelectUseCase;
	
	
	ArticleSaveByJsonService(
			BoardCommandDbPort boardDbPort,
			ArticleCommandDbPort dbPort,			
			ArticleAttachedFileDbPort attachedFileDbPort,
			FileUploadUseCase uploadUseCase,
			FileInfoDTOSelectUseCase fileSelectUseCase
			) {
		this.dbPort = dbPort;
		this.boardDbPort = boardDbPort;
		this.attachedFileDbPort = attachedFileDbPort;
		this.uploadUseCase = uploadUseCase;		
		this.fileSelectUseCase = fileSelectUseCase;
	}
	
	@Override
	public void save(ArticleFormSaveDTO dto) {
		Board board = boardDbPort.select(Base64Util.fromBase64Decode(dto.boardId()))
								 .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시판입니다."));		
						
		Article entity = StringUtils.hasText(dto.articleId()) ? this.findArticle(dto.articleId()) : null; 
								
		if (entity == null) {
			entity = ArticleFormSaveDTOMapper.newArticle(dto, board); 
		} else {
			ArticleFormSaveDTOMapper.modifyArticle(dto, entity);
		}
				
		this.dbPort.save(entity);		
		
		if (dto.attachFile() != null) {
			List<FileInfoDTO> fileInfoList = findFileInfoList(dto.attachFile());
			
			// FileInfo를 AttachedFile로 변환한다.
			List<ArticleAttachedFile> attachedFileList = AttachedFileConverter.convert(entity, fileInfoList);
															
			if (!attachedFileList.isEmpty()) entity.setFiles(attachedFileList);
						
			this.attachedFileDbPort.save(attachedFileList);		
		}		
		
	}
	
	private Article findArticle(String articleId) {
		return this.dbPort.select(Base64Util.fromBase64Decode(articleId)).orElse(null);
	}
	
	private List<FileInfoDTO> findFileInfoList(List<String> ids) {
		return fileSelectUseCase.select(ids); 
	}

}
