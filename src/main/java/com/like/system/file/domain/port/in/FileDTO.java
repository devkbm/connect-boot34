package com.like.system.file.domain.port.in;

import java.io.File;

public record FileDTO(
		File file,
		long size,
		String fileName,
		String mimeType
		) {

}
