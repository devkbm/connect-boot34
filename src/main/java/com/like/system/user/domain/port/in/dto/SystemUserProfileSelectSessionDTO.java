package com.like.system.user.domain.port.in.dto;

import java.util.Date;

public record SystemUserProfileSelectSessionDTO(
		String ipAddress,
		Date lastAccessedTime) {

}
