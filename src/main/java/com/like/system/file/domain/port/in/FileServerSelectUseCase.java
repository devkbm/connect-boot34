package com.like.system.file.domain.port.in;

import java.util.List;

import com.like.system.file.domain.FileInfo;

public interface FileServerSelectUseCase {

	FileInfo select(String id);
	
	List<FileInfo> select(List<String> ids);
}
