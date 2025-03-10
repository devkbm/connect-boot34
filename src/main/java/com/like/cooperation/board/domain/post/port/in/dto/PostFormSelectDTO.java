package com.like.cooperation.board.domain.post.port.in.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.like.system.file.export.FileInfoDTO;
import com.like.system.file.export.FileResponseDTO;

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
	List<FileResponseDTO> fileList;
		
	public void addFileList(List<FileInfoDTO> fileInfoList) {
    	List<FileResponseDTO> responseList = new ArrayList<>();	
    	
    	for (FileInfoDTO fileInfo : fileInfoList) {							
			responseList.add(FileResponseDTO.convert(fileInfo));				
		}
    	    	
    	this.setFileList(responseList);    	
    }
}
