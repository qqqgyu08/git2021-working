package com.git.controller.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	// CORS(cross origin resource sharing)을 설정
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.
		// 공유정책을 적용할 리소스
				addMapping("/**") // 전체리소스를 허용(/todos, /contacts ...)

				// 공유 정책을 허용할 오리진 목록
				// origin: html문서를 배포한 서버의 주소
				// html문서에는 어디서 문서를 받아왔는지를 기록하고 있음
				// 브라우저 -> 서버
				.allowedOrigins("http://localhost:3000", "ec2-52-78-167-183.ap-northeast-2.compute.amazonaws.com")
				// 공유정책으로 허용할 HTTP메서드
				.allowedMethods("*"); // 전체메서드를 허용(GET, POST, PUT,....)
	}
}
