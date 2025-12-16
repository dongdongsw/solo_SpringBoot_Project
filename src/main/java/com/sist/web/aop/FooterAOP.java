package com.sist.web.aop;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.web.service.ExerciseService;
import com.sist.web.vo.ExerciseVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class FooterAOP {

	private final ExerciseService eService;
	
	@After("execution(* com.sist.web.controller.*Controller.*(..))")
	public void after() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		List<ExerciseVO> exerciseTop10List = eService.exerciseTop10Data();
		request.setAttribute("exerciseTop10List", exerciseTop10List);
	}
}
