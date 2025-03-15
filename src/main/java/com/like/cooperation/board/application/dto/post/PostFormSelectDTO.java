package com.like.cooperation.board.application.dto.post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.like.cooperation.board.adapter.out.file.PostAttachedFileServerRepository;
import com.like.cooperation.board.domain.post.PostAttachedFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostFormSelectDTO {

	LocalDateTime createdDt;
	String createdBy;
	LocalDateTime modifiedDt;
	String modifiedBy;
	String userName;
	Long boardId;
	Long postId;
	Long postParentId;
	String title;
	String contents;
	String pwd;
	int hitCount;				
	Integer depth;	
	Boolean editable;	
	List<PostAttachedFileDTO> fileList;
	
	public void addFileList(List<PostAttachedFile> files) {
    	List<PostAttachedFileDTO> responseList = new ArrayList<>();	
    	
    	for (PostAttachedFile file : files) {							
			responseList.add(
					PostAttachedFileDTO
						.builder()
						.uid(file.getPostFileId().toString())
						.name(file.getFileName())
						.size(file.getSize())
						.contentType(file.getContentType())
						.url(PostAttachedFileServerRepository.fileDownLoadUrl+file.getPostFileId())
						.build()
						);				
		}
    	    	
    	this.setFileList(responseList);    	
    }
	
	/*
	List<FileResponseDTO> fileList;		
	public void addFileList(List<FileInfoDTO> fileInfoList) {
    	List<FileResponseDTO> responseList = new ArrayList<>();	
    	
    	for (FileInfoDTO fileInfo : fileInfoList) {							
			responseList.add(FileResponseDTO.convert(fileInfo));				
		}
    	    	
    	this.setFileList(responseList);    	
    }
    */
}
