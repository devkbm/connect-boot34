package com.like.cooperation.board.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "board")
public class PostAttachedFileProperties {

	String uploadPath;
}
