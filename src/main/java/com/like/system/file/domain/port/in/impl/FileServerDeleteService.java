package com.like.system.file.domain.port.in.impl;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;

import com.like.system.file.adapter.out.file.FileServerRepository;
import com.like.system.file.domain.FileInfo;
import com.like.system.file.domain.port.in.FileServerDeleteUseCase;
import com.like.system.file.domain.port.out.FileInfoCommandDbPort;

@Service
public class FileServerDeleteService implements FileServerDeleteUseCase {

	FileInfoCommandDbPort dbPort;
	FileServerRepository fileServerRepository;
	
	FileServerDeleteService(FileInfoCommandDbPort dbPort, FileServerRepository fileServerRepository) {
		this.dbPort = dbPort;
		this.fileServerRepository = fileServerRepository;
	}
	
	@Override
	public void delete(String fileInfoId) {
		
		FileInfo fileInfo = dbPort.getFileInfo(fileInfoId);
		
		try {
			fileServerRepository.deleteFile(new File(fileInfo.getPath(), fileInfo.getUuid()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		this.dbPort.delete(fileInfoId);		
	}

}
